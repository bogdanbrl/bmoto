package com.doubleb.bmoto.service;

import com.doubleb.bmoto.dto.BillingAddress;
import com.doubleb.bmoto.entity.*;
import com.doubleb.bmoto.model.Cart;
import com.doubleb.bmoto.repository.PaymentRepository;
import com.doubleb.bmoto.utils.Status;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private AddressService addressService;
    private CustomerService customerService;
    private CartService cartService;
    private ProductService productService;
    private OrderService orderService;
    private PaymentRepository paymentRepository;
    private OrderProductService orderProductService;

    public PaymentService() {
    }

    @Autowired
    public PaymentService(AddressService addressService, CustomerService customerService, CartService cartService,
                          ProductService productService, OrderService orderService, PaymentRepository paymentRepository,
                          OrderProductService orderProductService) {
        this.addressService = addressService;
        this.customerService = customerService;
        this.cartService = cartService;
        this.productService = productService;
        this.orderService = orderService;
        this.paymentRepository = paymentRepository;
        this.orderProductService = orderProductService;
    }

    public BillingAddress getBillingAddress(String currentPrincipalName) {
        BillingAddress billingAddress = new BillingAddress();

        User user = customerService.getUserByUsername(currentPrincipalName);
        Address address = addressService.getAddressByUserId(user.getId());

        billingAddress.setFirstName(user.getFirstName());
        billingAddress.setLastName(user.getLastName());
        billingAddress.setEmail(user.getEmail());
        billingAddress.setPhone(user.getPhone());
        billingAddress.setAddressLine1(address.getAddressLine1());
        billingAddress.setAddressLine2(address.getAddressLine2());
        billingAddress.setCity(address.getCity());
        billingAddress.setCountry(address.getCountry());
        billingAddress.setCounty(address.getCounty());
        billingAddress.setPostalCode(address.getPostalCode());

        billingAddress.setUserID(user.getId());
        billingAddress.setAddressID(address.getId());

        return billingAddress;
    }


    @Transactional
    public void placeOrder(HttpSession session, Principal principal, BillingAddress billingAddress, Cart cart) {

        User user = updateUser(principal, billingAddress);
        Address address = updateAddress(user, billingAddress);
        updateSaveUserAddress(user, address, billingAddress);
        updateSaveOrderAndPayment(user, cart);
        cartService.emptyCart(session);

    }

    private void updateSaveOrderAndPayment(User user, Cart cart) {
        Order order = new Order();
        order.setOrderNo(generateOrderNumber(10));
        order.setCreatedAt(LocalDateTime.now());
        order.setDeletedFlag(false);
        order.setStatus(Status.PENDING.name());
        Order savedOrder = orderService.save(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        cart.getItems().forEach(i -> {
            boolean available = checkProductAvailability(i.getProduct().getId(), i.getQty());
            if (available){
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setProduct(productService.getProductById(i.getProduct().getId()));
                orderProduct.setCreatedAt(LocalDateTime.now());
                orderProduct.setDeletedFlag(false);
                orderProduct.setPricePerItem(i.getProductPrice());
                orderProduct.setQuantity(i.getQty());
                orderProduct.setOrder(savedOrder);

                OrderProduct savedOrderProduct = orderProductService.save(orderProduct);
                orderProducts.add(savedOrderProduct);
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested quantity for product: " + i.getProduct().getName() + " not available!");
            }
        });
        savedOrder.setOrderProducts(orderProducts);

        Payment payment = new Payment();
        payment.setAmount(cart.getTotal());
        payment.setOrder(savedOrder);
        payment.setCreatedAt(LocalDateTime.now());
        payment.setStatus(Status.PENDING.name());
        payment.setDeletedFlag(false);
        Payment savedPayment = paymentRepository.save(payment);
        savedOrder.setPayment(savedPayment);
        savedOrder.setUser(user);
        orderService.save(savedOrder);
    }

    private String generateOrderNumber(int length) {
        String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    private boolean checkProductAvailability(Long productId, int requestedQty) {
        Inventory inventory = productService.getProductInventory(productId);
        if (inventory.getQuantity() >= requestedQty){
            productService.updateProductInventoryQuantity(inventory.getId(), (inventory.getQuantity()-requestedQty));
            return true;
        }
        return false;
    }

    private User updateUser(Principal principal, BillingAddress billingAddress){
        String currentPrincipalName = principal.getName();
        User user = customerService.getUserByUsername(currentPrincipalName);
        user.setFirstName(billingAddress.getFirstName());
        user.setLastName(billingAddress.getLastName());
        user.setEmail(billingAddress.getEmail());
        user.setPhone(billingAddress.getPhone());
        User savedUser = customerService.save(user);
        return savedUser;
    }

    private Address updateAddress(User user, BillingAddress billingAddress){
        Address address = null;
        if(billingAddress.getAddressID() == null){
            address = new Address();
        }else {
            address = addressService.getAddressByUserId(user.getId());
        }
        address.setAddressLine1(billingAddress.getAddressLine1());
        address.setAddressLine2(billingAddress.getAddressLine2());
        address.setCountry(billingAddress.getCountry());
        address.setCity(billingAddress.getCity());
        address.setCounty(billingAddress.getCounty());
        address.setPostalCode(billingAddress.getPostalCode());
        address.setCreatedAt(LocalDateTime.now());
        address.setDeletedFlag(false);
        address.setPhone(billingAddress.getPhone());
        Address savedAddress = customerService.save(address);
        return savedAddress;
    }

    private void updateSaveUserAddress(User user, Address address, BillingAddress billingAddress){
        if (billingAddress.getAddressID() == null){
            UserAddress userAddress = new UserAddress();
            userAddress.setCreatedAt(LocalDateTime.now());
            userAddress.setDeletedFlag(false);
            userAddress.setUser(user);
            userAddress.setAddress(address);
            customerService.save(userAddress);
        }
    }
}

package com.doubleb.bmoto.web.controller;

import com.doubleb.bmoto.dto.BillingAddress;
import com.doubleb.bmoto.model.Cart;
import com.doubleb.bmoto.service.CartService;
import com.doubleb.bmoto.service.PaymentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CartService cartService;

    public PaymentController() {
    }

    public PaymentController(PaymentService paymentService, CartService cartService) {
        this.paymentService = paymentService;
        this.cartService = cartService;
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model, Principal principal, HttpSession session){

        String currentPrincipalName = principal.getName();
        BillingAddress billingAddress = paymentService.getBillingAddress(currentPrincipalName);
        Cart cart = cartService.getCart(session);
        model.addAttribute("cart", cart);
        model.addAttribute("billingAddress", billingAddress);

        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(@Valid BillingAddress billingAddress, Cart cart, BindingResult result, HttpSession session, Principal principal){
        if (result.hasErrors()) {
            System.out.println("comanda esuata");
            return "checkout";
        }
        paymentService.placeOrder(session, principal, billingAddress, cartService.getCart(session));
        System.out.println("comanda plasata");
        return "checkout";
    }

}

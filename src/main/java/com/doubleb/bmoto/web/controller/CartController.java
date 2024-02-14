package com.doubleb.bmoto.web.controller;

import com.doubleb.bmoto.entity.Product;
import com.doubleb.bmoto.model.Cart;
import com.doubleb.bmoto.service.CartService;
import com.doubleb.bmoto.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;
    private ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("")
    public String showCartPage(HttpSession session, Model model){
        Cart cart = cartService.getCart(session);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<String> updateQuantity(HttpSession session, @RequestParam int index, @RequestParam int quantity) {
        try {
            Cart cart = cartService.getCart(session);
            Product product = cart.getItems().get(index).getProduct();
            cartService.update(session,product, quantity);
            return ResponseEntity.ok("Quantity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update quantity");
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> remove(HttpSession session, @RequestParam int index){
        try {
            Cart cart = cartService.getCart(session);
            Product product = cart.getItems().get(index).getProduct();
            cartService.remove(session, product);
            return ResponseEntity.ok("Quantity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update quantity");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCartFromShopPage(HttpSession session, @RequestParam("id") int id, @RequestParam(value = "qty", required = false, defaultValue = "1") int qty){
        try {
            Product product = productService.findProductByID((long) id);
            cartService.add(session, product, qty);
            return ResponseEntity.ok("Product added to cart successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product to cart");
        }
    }

    @PutMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Product product, @RequestParam("qty") int qty){
        cartService.update(session, product, qty);
        return "redirect:/cart";
    }

    @GetMapping("/contact")
    public String showContactPage(){
        return "contact";
    }

    @GetMapping("/itemCount")
    public int getCartItemCount(HttpSession session){
        Cart cart = cartService.getCart(session);
        return cart.getItemCount();
    }
}

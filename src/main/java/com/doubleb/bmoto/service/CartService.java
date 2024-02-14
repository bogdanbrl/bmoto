package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Product;
import com.doubleb.bmoto.model.Cart;
import com.doubleb.bmoto.model.CartManager;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartManager cartManager;
    @Autowired
    private ProductService productService;

    public CartService() {
    }

    public CartService(CartManager cartManager, ProductService productService) {
        this.cartManager = cartManager;
        this.productService = productService;
    }

    public void add(HttpSession session, Product product, int qty){
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, qty);
    }

    public void remove(HttpSession session, Product product){
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
    }

    public void update(HttpSession session, Product product, int qty){
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, qty);
    }

    public Cart getCart(HttpSession session){
        return cartManager.getCart(session);
    }

    public void emptyCart(HttpSession session){
        cartManager.removeCart(session);
    }
}

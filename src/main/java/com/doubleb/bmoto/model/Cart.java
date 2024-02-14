package com.doubleb.bmoto.model;

import com.doubleb.bmoto.entity.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<CartItem> items;
    private double shipping;
    private double subtotal;
    private double total;

    public Cart() {
        this.items = new ArrayList<>();
        this.subtotal = 0;
        this.shipping = 25;
        this.total = 0;
    }

    public CartItem getItem(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()){
                return item;
            }
        }
        return null;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getItemCount(){
        return items.size();
    }

    public void addItem(CartItem item){
        addItem(item.getProduct(), item.getQty());
    }

    public void addItem(Product product, int quantity){
        CartItem item = getItem(product);

        if (item != null){
            item.setQty(item.getQty() + quantity);
        } else {
            item = new CartItem(product);
            item.setQty(quantity);
            items.add(item);
        }
    }

    public void updateItem(Product product, int quantity){ // throws ProductNotFoundException
        CartItem item = getItem(product);

        if (item != null){
            item.setQty(quantity);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public void removeItem(Product product){ // throws ProductNotFoundException
        CartItem item = getItem(product);

        if (item != null){
            items.remove(item);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public void clear(){
        items.clear();
        subtotal = 0;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public double getSubtotal(){
        subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getSubTotal();
        }
        BigDecimal bd = new BigDecimal(subtotal).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public double getShipping() {
        if (items.size() < 1) {
            return 0;
        }
        return shipping;
    }

    public double getTotal() {
        total = getSubtotal() + getShipping();
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        return "Cart{" +
                " shipping=" + shipping +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }
}

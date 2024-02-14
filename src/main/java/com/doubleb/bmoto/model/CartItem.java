package com.doubleb.bmoto.model;

import com.doubleb.bmoto.entity.Product;

import java.text.DecimalFormat;

public class CartItem {

    private final Product product;
    private double productPrice;
    private int qty;
    private double subTotal;

    public CartItem(Product product) {
        this.product = product;
        this.qty = 1;
        this.productPrice = getProductPrice();
        this.subTotal = product.getPrice();
    }

    public double getProductPrice() {
        if (product.getDiscount().getDiscountPercent() > 0) {
            return (product.getPrice() - (product.getDiscount().getDiscountPercent() * product.getPrice()) / 100);
        }else {
            return product.getPrice();
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubTotal() {
        if (product.getDiscount().getDiscountPercent() > 0) {
            DecimalFormat twoDecimals = new DecimalFormat("#.##");
            this.subTotal = Double.parseDouble(twoDecimals.format(this.qty * (product.getPrice() - (product.getDiscount().getDiscountPercent() * product.getPrice()) / 100)));
        }else {
            this.subTotal = this.qty * product.getPrice();
        }
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return product != null ? product.equals(cartItem.product) : cartItem.product == null;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                '}';
    }
}

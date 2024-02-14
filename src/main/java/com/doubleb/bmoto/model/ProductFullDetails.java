package com.doubleb.bmoto.model;

import com.doubleb.bmoto.entity.*;

public interface ProductFullDetails {

    Product getProduct();
    Colour getColour();
    Gender getGender();
    Size getSize();
    Category getCategory();
    Inventory getInventory();
    Discount getDiscount();

}

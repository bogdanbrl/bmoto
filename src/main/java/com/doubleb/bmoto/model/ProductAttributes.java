package com.doubleb.bmoto.model;

import com.doubleb.bmoto.entity.Category;
import com.doubleb.bmoto.entity.Colour;
import com.doubleb.bmoto.entity.Gender;
import com.doubleb.bmoto.entity.Size;

import java.util.List;

public class ProductAttributes {

    private List<Colour> colours;
    private List<Size> sizes;
    private List<Gender> genders;
    private List<Category> categories;

    public List<Colour> getColours() {
        return colours;
    }

    public void setColours(List<Colour> colours) {
        this.colours = colours;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

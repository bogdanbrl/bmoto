package com.doubleb.bmoto.service.filter.v2.search;


import java.time.LocalDateTime;

public class SearchProductCriteria {

    private String name;
    private String description;
    private Double minPrice = 0.0D;
    private Double maxPrice = 1_000_000.0D;
    private LocalDateTime minCreatedAt;
    private LocalDateTime maxCreatedAt;
    private String manufacturer;
    private String category;
    private Integer minQuantity;
    private Integer maxQuantity;
    private Double minDiscount;
    private Double maxDiscount;
    private String colour;
    private String size;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public LocalDateTime getMinCreatedAt() {
        return minCreatedAt;
    }

    public void setMinCreatedAt(LocalDateTime minCreatedAt) {
        this.minCreatedAt = minCreatedAt;
    }

    public LocalDateTime getMaxCreatedAt() {
        return maxCreatedAt;
    }

    public void setMaxCreatedAt(LocalDateTime maxCreatedAt) {
        this.maxCreatedAt = maxCreatedAt;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMinDiscount() {
        return minDiscount;
    }

    public void setMinDiscount(Double minDiscount) {
        this.minDiscount = minDiscount;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return "SearchProductCriteria{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minCreatedAt=" + minCreatedAt +
                ", maxCreatedAt=" + maxCreatedAt +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", minQuantity=" + minQuantity +
                ", maxQuantity=" + maxQuantity +
                ", minDiscount=" + minDiscount +
                ", maxDiscount=" + maxDiscount +
                ", colour='" + colour + '\'' +
                ", size='" + size + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

package com.doubleb.bmoto.dto;

import jakarta.validation.constraints.*;

public class BillingAddress {

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String firstName;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String lastName;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Email
    private String email;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    private String phone;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String addressLine1;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String addressLine2;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String country;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String city;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String county;

    @NotBlank(message = "is required")
    @NotEmpty(message = "is required")
    @Size(min=1, message="is required")
    private String postalCode;

    private Long userID;
    private Long addressID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", userID=" + userID +
                ", addressID=" + addressID +
                '}';
    }
}

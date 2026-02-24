package com.spring.fieldInjection;

public class Address {

    public String villageName;
    public String city;
    public String country;

    // REQUIRED for field injection
    public Address() {
        this.villageName = "Rewari";
        this.city = "Rewari";
        this.country = "India";
    }
}
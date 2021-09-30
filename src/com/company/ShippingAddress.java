package com.company;

import java.util.Scanner;

public class ShippingAddress {
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String zipCode;

    public ShippingAddress(String address1,String address2, String state, String city, String zipCode){
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public String toString(){
        return "Shipping address is: "+ address1 + " "+ address2 + " "+ state + " "+ city + " " + zipCode;
    }
}

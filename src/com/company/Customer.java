package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<ShippingAddress> addresses;
    private String name;
    private static int customerID = 0;

    public Customer(String name) {
        this.name = name;
        this.customerID += 1;
    }


    public String getName() {
        return name;
    }
    public void addAddress(ShippingAddress newAddress){
        this.addresses.add(newAddress);
    }


    public String toString(){
        return name + " " + customerID;
    }
}

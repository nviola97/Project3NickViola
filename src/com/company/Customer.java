package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<ShippingAddress> addresses;
    private String name;
    private  int customerID;
    private static int nextID = 100;

    public Customer(String name) {
        addresses = new ArrayList<ShippingAddress>();
        this.name = name;
        customerID = nextID;
        nextID++;
    }
    public int getId(){
        return customerID;
    }

    public ArrayList<ShippingAddress> getAddresses() {
        return addresses;
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

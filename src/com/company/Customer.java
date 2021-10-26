package com.company;

import java.util.ArrayList;

public abstract class Customer {
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
    public abstract double PayForOrder(ArrayList<merchandiseItem> itemsInOrder);

    public double payOutstandingBalance(){
        return 0.0;
    }

    public void arrangeDelivery(){
        System.out.println(name + " deliver any time");
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

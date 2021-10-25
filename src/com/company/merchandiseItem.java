package com.company;

public class merchandiseItem {
    private ItemType taxibleType;
    private String Name;
    private double price;

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getType(){
        return taxibleType;
    }
}

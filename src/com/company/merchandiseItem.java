package com.company;

public class merchandiseItem {
    private ItemType taxableType;
    private String Name;
    private double price;

    public merchandiseItem(String Name,ItemType taxableType, double price){
        this.taxableType = taxableType;
        this.Name = Name;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getType(){
        return taxableType;
    }
}

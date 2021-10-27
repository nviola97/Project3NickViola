package com.company;

import java.util.ArrayList;

public class Order {
    private ShippingAddress destination;
    private Customer orderedBy;
    private ArrayList<merchandiseItem> cartForOrder;

    public Order(ShippingAddress destination, Customer orderedBy, ArrayList<merchandiseItem> cartForOrder){
        this.destination = destination;
        this.cartForOrder = cartForOrder;
        this.orderedBy = orderedBy;

    }
    public String getDestination() {
        return destination.toString();
    }
    public String getOrderer(){
        return orderedBy.toString();
    }
    public String getCart(){ return cartForOrder.toString(); }
}

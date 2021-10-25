package com.company;

import java.util.ArrayList;

public class ResidentialCustomer extends Customer{
    public ResidentialCustomer(String name) {
        super(name);
    }

    @Override
    public double PayForOrder(ArrayList<ItemsForSale> itemsInOrder) {
        return super.PayForOrder(itemsInOrder);
    }
}

package com.company;

import java.util.ArrayList;

public class TaxExemptCustomer extends Customer{
    public TaxExemptCustomer(String name) {
        super(name);
    }

    @Override
    public double PayForOrder(ArrayList<ItemsForSale> itemsInOrder) {
        return super.PayForOrder(itemsInOrder);
    }

    @Override
    public void arrangeDelivery() {
        super.arrangeDelivery();
    }
}

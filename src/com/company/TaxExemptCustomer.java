package com.company;

import java.util.ArrayList;

public class TaxExemptCustomer extends Customer{
    public TaxExemptCustomer(String name) {
        super(name);
    }

    public double PayForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        return PayForOrder(itemsInOrder);
    }

    @Override
    public void arrangeDelivery() {
        super.arrangeDelivery();
    }
}

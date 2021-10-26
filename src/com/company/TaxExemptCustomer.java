package com.company;

import java.util.ArrayList;

public class TaxExemptCustomer extends Customer{
    public TaxExemptCustomer(String name) {
        super(name);
    }

    public double PayForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        double sum = 0.0;
        for (var item : itemsInOrder) {
            sum+= item.getPrice();
        }
        return sum;
    }

    @Override
    public void arrangeDelivery() {
        super.arrangeDelivery();
    }
}

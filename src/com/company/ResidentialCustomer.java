package com.company;

import java.util.ArrayList;

public class ResidentialCustomer extends Customer {
    public ResidentialCustomer(String name) {
        super(name);
    }

    @Override
    public double PayForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        double sum = 0.0;
        for (var item : itemsInOrder) {
            switch (item.getType()) {
                case GeneralMerchandise:
                     sum +=item.getPrice() * 0.0625;
                case Clothing:
                    if (item.getPrice() > 175) {
                        sum += item.getPrice() * 0.0625;
                    } else {
                        sum += item.getPrice();
                    }
                default:
                    sum = +item.getPrice();
            }
        }
        return sum;
    }
}
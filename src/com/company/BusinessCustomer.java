package com.company;

import java.util.ArrayList;

public class BusinessCustomer extends Customer {
    private double purchaseOrderBalance;

    public BusinessCustomer(String name) {
        super(name);
    }
    @Override
    public double PayForOrder(ArrayList<ItemsForSale> itemsInOrder) {

    }

    @Override
    public double payOutstandingBalance() {
        return super.payOutstandingBalance();
    }

    @Override
    public void arrangeDelivery() {
        super.arrangeDelivery();
    }
}

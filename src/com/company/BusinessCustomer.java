package com.company;

import java.util.ArrayList;

public class BusinessCustomer extends Customer {
    private double purchaseOrderBalance;

    public BusinessCustomer(String name) {
        super(name);
    }
    @Override
    public double PayForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        System.out.println("Thank you " + getName() + " your purchase order will be charged.");
        for (var item : itemsInOrder) {
            switch (item.getType()) {
                case GeneralMerchandise:
                    purchaseOrderBalance += item.getPrice() * 0.0625;
                case Clothing:
                    if (item.getPrice() > 175) {
                        purchaseOrderBalance += item.getPrice() * 0.0625;
                    } else {
                        purchaseOrderBalance += item.getPrice();
                    }
                default:
                    purchaseOrderBalance = +item.getPrice();
            }
        }
        return 0;
    }

    @Override
    public double payOutstandingBalance() {
        if(purchaseOrderBalance > 1000){
            double discountBalance = purchaseOrderBalance - purchaseOrderBalance * 0.05;
            System.out.println(purchaseOrderBalance);
            purchaseOrderBalance = 0.0;
        }
        else{
            System.out.println(purchaseOrderBalance);
            purchaseOrderBalance = 0.0;
        }
        return super.payOutstandingBalance();
    }

    @Override
    public void arrangeDelivery() {
        System.out.println("Hello" + getName() + " your order will be delivered on set date Mon-Fri 9am-5pm");
        super.arrangeDelivery();
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;

    public static void main(String[] args) {
    }
    public void runStore(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" [1] Add Customer");
        System.out.println(" [2] Select Customer");
        System.out.println(" [3] Quit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        var menuReader = new Scanner(System.in);
        while(true){
            var userChoice= menuReader.nextInt();
            switch (userChoice){
                case 1:
                    addCustomer();
                    break;
                case 2:
                    selectCustomer();
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }
    public void makeOrder(ShippingAddress address, Customer cust){
    }
    public void Store(){
    }
    public void addCustomer(){
    }
    public Customer selectCustomer(){
    }
    public void manageCustomer(Customer selectedCustomer){

    }
}

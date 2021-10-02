package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Store {
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;


    public static void main(String[] args) {
    }

    public ArrayList<Customer> getCustomers()throws IOException {
        var fileName = "Customer";
        var filePath = Paths.get(fileName);
        var allLines = Files.readAllLines(filePath);
        for (var line : allLines) {
            var splitLine = line.split(",");
            customers.add(splitLine[0]);
        }
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
        var inputReader = new Scanner(System.in);
            System.out.println("What is the name of the Customer?: ");
        var custName = inputReader.nextLine();


    }
    public Optional<Customer> selectCustomer(Scanner reader){
        System.out.println("What");
    }
    public void manageCustomer(Customer selectedCustomer){
        var menuReader = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println(" [1] Add Address");
        System.out.println(" [2] Make Order");
        System.out.println(" [3] Back");
        System.out.println("**************************");
        while(true){
            var custChoice = menuReader.nextInt();
            switch (custChoice){
                case 1:

                case 2:

                case 3:
                    runStore();
                    break;
            }
        }

    }
    }

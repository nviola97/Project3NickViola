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
    public Store() {
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
    }

    public static void main(String[] args) {
        Store nicks = new Store() ;
        nicks.runStore();
    }


    public void getCustomers()throws IOException {
        var fileName = "Customer";
        var filePath = Paths.get(fileName);
        var allLines = Files.readAllLines(filePath);
        var splitLine = allLines.get(0).split(", ");
        for (var name : splitLine) {
            Customer customer = new Customer(name);
            customers.add(customer);
        }
    }

    public void runStore(){
        try {
            getCustomers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        var menuReader = new Scanner(System.in);
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" [1] Add Customer");
            System.out.println(" [2] Select Customer");
            System.out.println(" [3] Quit");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            var userChoice= menuReader.nextInt();
            switch (userChoice){
                case 1:
                    addCustomer();
                    break;
                case 2:
                    Optional<Customer> current = selectCustomer(menuReader);
                    if(current.isPresent())
                        manageCustomer(menuReader, current.get());
                    else
                        System.out.println("No customer with that ID found");
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }


    public void makeOrder(ShippingAddress address, Customer cust){
    }

    public void addCustomer(){
        var inputReader = new Scanner(System.in);
            System.out.println("What is the name of the Customer?: ");
         var custName = inputReader.nextLine();
        Customer customer = new Customer(custName);
        customers.add(customer);
        System.out.println(custName + " has been added to customers with ID " + customer.getId());



    }
    public Optional<Customer> selectCustomer(Scanner reader){
        System.out.println("Input Customer ID: ");
        var idToFind = reader.nextInt();
        for (var currentCustomer: customers){
            if(currentCustomer.getId() == idToFind)
                return Optional.of(currentCustomer);
        }
        return Optional.empty();
    }
    public void manageCustomer(Scanner menuReader ,Customer currentCustomer){
        System.out.println("Current client is: "+ currentCustomer.getName());
        System.out.println("**************************");
        System.out.println(" [1] Add Address");
        System.out.println(" [2] Make Order");
        System.out.println(" [3] Back");
        System.out.println("**************************");
        while(true){
            var custChoice = menuReader.nextInt();
            switch (custChoice){
                case 1:
                    //print out question address 1
                    // String address 1 = menuReader.nextString
                    //use menuReader to extract answer into variable
                    // address 2 and so on
                    //
                    currentCustomer.addAddress(new ShippingAddress());

                case 2:

                case 3:
                    runStore();
                    break;
            }
        }

    }
    }

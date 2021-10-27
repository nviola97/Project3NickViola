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
    private ArrayList<merchandiseItem> stock;
    private double revenue;

    public Store() {
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        stock = new ArrayList<merchandiseItem>();
    }

    public static void main(String[] args) {
        Store nicks = new Store() ;
        nicks.runStore();
    }

    public void getStock() throws IOException {
        var fileName = "merchandiseItem";
        var filePath = Paths.get(fileName);
        var allLines = Files.readAllLines(filePath);
        for (var line : allLines) {
            var splitLine = line.split("; ");
            var price = Double.parseDouble(splitLine[2]);
            ItemType type;
            switch (splitLine[1]){
                case "Clothing":
                    type = ItemType.Clothing;
                case "WICFood":
                    type =ItemType.WICFood;
                case "GeneralMerchandise":
                    type = ItemType.GeneralMerchandise;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + splitLine[1]);
            }

            merchandiseItem item = new merchandiseItem(splitLine[0], type, price);
            stock.add(item);

        }
    }


    public void getCustomers()throws IOException {
        var fileName = "Customer";
        var filePath = Paths.get(fileName);
        var allLines = Files.readAllLines(filePath);
        var splitLine = allLines.get(0).split(", ");
        for (var name : splitLine) {
            Customer customer = new ResidentialCustomer(name);
            customers.add(customer);
        }
    }

    public void runStore(){
        try {
            getCustomers();
            getStock();
        } catch (IOException e) {
            e.printStackTrace();
        }
        var menuReader = new Scanner(System.in);
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" [1] Add Customer");
            System.out.println(" [2] Select Customer");
            System.out.println(" [3] Collect Revenue");
            System.out.println(" [4] Quit");
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
                    for(int i = 0; i< orders.size(); i++){
                        orders.get(i).getOrderer();
                        // could not figure it out
                    }
                    break;
                case 4:
                    System.exit(0);


            }
        }

    }


    public void makeOrder(ShippingAddress address, Customer cust) {
        ArrayList<merchandiseItem> cart = new ArrayList<merchandiseItem>();
        var menuReader = new Scanner(System.in);
        while (true) {
            System.out.println("Choose items to add to cart.");
            System.out.println("############################");
            for (int i = 0; i < stock.size(); i++) {
                System.out.println("[" + (i+1) + "] " + stock.get(i).getName());
            }
            System.out.println("[0] Quit");
            System.out.println("############################");
            var itemChoice = menuReader.nextInt()-1;
            if (itemChoice == -1){
                break;
            }
            else{
                cart.add(stock.get(itemChoice));
            }
        }
        Order custOrder = new Order(address, cust, cart);
        orders.add(custOrder);
        System.out.println("Your order has been placed");
    }
    public void addCustomer(){
        var inputReader = new Scanner(System.in);
            System.out.println("What is the name of the Customer?: ");
         var custName = inputReader.nextLine();
         System.out.println("Input customer type: ");
        System.out.println("**************************");
        System.out.println(" [1] Business");
        System.out.println(" [2] Residential");
        System.out.println(" [3] Tax Exempt");
        System.out.println("**************************");
        var custType = inputReader.nextInt();
        Customer customer;
        switch (custType){
            case 1:
                customer = new BusinessCustomer(custName);
                break;
            case 3:
                customer = new TaxExemptCustomer(custName);
                break;
            default:
                customer = new ResidentialCustomer(custName);
                break;
        }
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
        while(true){
            System.out.println("Current client is: "+ currentCustomer.getName());
            System.out.println("**************************");
            System.out.println(" [1] Add Address");
            System.out.println(" [2] Make Order");
            System.out.println(" [3] Back");
            System.out.println("**************************");
            var custChoice = menuReader.nextInt();
            switch (custChoice){
                case 1:
                    System.out.println("Enter the Address 1: ");
                    menuReader.nextLine();
                    String address1 = menuReader.nextLine();
                    System.out.println("Enter the Address 2: ");
                    String address2 = menuReader.nextLine();
                    System.out.println("Enter the State: ");
                    String state = menuReader.nextLine();
                    System.out.println("Enter the City: ");
                    String city = menuReader.nextLine();
                    System.out.println("Enter the Zip Code: ");
                    String zipCode = menuReader.nextLine();
                    var newAddress = new ShippingAddress( address1, address2, state, city, zipCode);
                    currentCustomer.addAddress(newAddress);
                    System.out.println(newAddress.toString() + " has been added.");
                    break;
                case 2:
                    if(currentCustomer.getAddresses().size() > 0) {
                        System.out.println("Choose an address");
                        System.out.println("############################");
                        for (int i = 0; i < currentCustomer.getAddresses().size(); i++) {
                            System.out.println("[" + i + "]  " + currentCustomer.getAddresses().get(i));
                        }
                        System.out.println("############################");
                        makeOrder(currentCustomer.getAddresses().get(menuReader.nextInt()), currentCustomer);
                    }
                    break;
                case 3:
                    runStore();
                    break;
            }
        }

    }

    }

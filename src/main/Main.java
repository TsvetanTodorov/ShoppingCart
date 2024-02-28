package main;

import main.entities.CustomerImpl;
import main.entities.ShopImpl;
import main.exceptions.InvalidFieldException;
import main.services.CommandService;
import main.services.CustomerService;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InvalidFieldException {

        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        ShopImpl shop = new ShopImpl();

        System.out.println("Welcome to the shop!");

        CustomerImpl customer = customerService.createCustomer(scanner);

        System.out.println("First, Let's add some items to the shop!");
        customer.info();

        String command = scanner.nextLine();

        CommandService commandService = new CommandService(shop, customer);
        commandService.runCommands(command, scanner);
    }

}
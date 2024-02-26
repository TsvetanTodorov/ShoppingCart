import entities.CustomerImpl;
import entities.Product;
import entities.ShopImpl;
import exceptions.InvalidFieldException;
import services.CommandService;
import services.CustomerService;

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
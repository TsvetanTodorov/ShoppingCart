package services;

import entities.CustomerImpl;
import entities.Product;
import entities.ShopImpl;
import exceptions.InvalidFieldException;

import java.util.Scanner;

public class CommandService {
    private ShopImpl shop;
    private CustomerImpl customer;

    public CommandService(ShopImpl shop, CustomerImpl customer) {
        this.shop = shop;
        this.customer = customer;
    }

    public void runCommands(String command, Scanner scanner) {
        while (!command.equals("Cash Out")) {
            Product product;
            String[] commandArr = command.split("-");

            if (commandArr.length < 3) {
                System.out.println("Invalid command");
                command = scanner.nextLine();
                continue;
            }
            String commandType = commandArr[0];
            String productName = commandArr[1];
            String quantity = commandArr[2];
            Product currentProduct;
            switch (commandType) {
                case "add":
                    if (commandArr.length != 4) {
                        System.out.println("Invalid command");
                        command = scanner.nextLine();
                        continue;
                    }
                    String price = commandArr[3];
                    try {
                        product = new Product(productName, price, quantity);
                        shop.addProduct(product);
                    } catch (InvalidFieldException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "check":
                    customer.checkShoppingCart();
                    break;
                case "check all":
                    shop.checkAllProductsAvailability();
                    break;
                case "return":
                    productName = commandArr[1];
                    quantity = commandArr[2];
                    try {
                        currentProduct = customer.returnProduct(new Product(productName, quantity));
                    } catch (InvalidFieldException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    shop.returnProduct(currentProduct);
                    break;
                case "buy":
                    try {
                        productName = commandArr[1];
                        quantity = commandArr[2];
                        currentProduct = shop.getProduct(productName);
                        shop.buyProduct(new Product(productName, quantity));
                        Product productToBuy = new Product(productName, String.valueOf(currentProduct.getPrice()), quantity);
                        customer.buyProduct(productToBuy);
                    } catch (InvalidFieldException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "help":
                    customer.help();
                    break;
                case "cash out":
                    customer.cashOut();
                    return;
                default:
                    System.out.println("Nonexistent command!");
                    System.out.println("If you want to know all the available commands type help.");
                    break;
            }

            command = scanner.nextLine();
        }
    }

}

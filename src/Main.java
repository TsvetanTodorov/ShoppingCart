import entities.CustomerImpl;
import entities.Product;
import entities.ShopImpl;
import exceptions.InvalidFieldException;
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

        while (!command.equals("Cash Out")) {
            Product product;

            String[] commandArr = command.split("-");
            String commandType = commandArr[0];
            switch (commandType) {
                case "add":
                    String productName = commandArr[1];
                    String quantity = commandArr[2];
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
                    try {
                        productName = commandArr[1];
                        quantity = commandArr[2];
                        shop.returnProduct(new Product(productName, quantity));
                        customer.returnProduct(new Product(productName, quantity));
                    } catch (InvalidFieldException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "buy":
                    try {
                        productName = commandArr[1];
                        quantity = commandArr[2];
                        shop.buyProduct(new Product(productName, quantity));
                        customer.buyProduct(new Product(productName, quantity));
                    } catch (InvalidFieldException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            command = scanner.nextLine();
        }

    }

}
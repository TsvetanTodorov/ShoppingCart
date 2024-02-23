package services;

import entities.CustomerImpl;
import exceptions.InvalidFieldException;

import java.util.Scanner;

public class CustomerService {

    public CustomerService() {

    }

    public CustomerImpl createCustomer(Scanner scanner) {
        CustomerImpl customerImpl = new CustomerImpl();
        createCustomerName(customerImpl, scanner);
        createCustomerAge(customerImpl, scanner);
        createCustomerPhoneNumber(customerImpl, scanner);
        createCustomerAddress(customerImpl, scanner);
        createCustomerCity(customerImpl, scanner);

        System.out.println("Your registration was created successfully!");

        return customerImpl;
    }

    private void createCustomerName(CustomerImpl customerImpl, Scanner scanner) {
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        while (true) {
            try {
                customerImpl.setName(name);
                break;
            } catch (InvalidFieldException e) {
                System.out.println(e.getMessage());
            }

            name = scanner.nextLine();
        }
    }

    private void createCustomerAge(CustomerImpl customerImpl, Scanner scanner) {
        System.out.println("Please enter your age:");
        String age = scanner.nextLine();
        while (true) {
            try {
                customerImpl.setAge(age);
                break;
            } catch (InvalidFieldException e) {
                System.out.println(e.getMessage());
            }

            age = scanner.nextLine();
        }
    }

    private void createCustomerPhoneNumber(CustomerImpl customerImpl, Scanner scanner) {
        System.out.println("Please enter your phone number:");
        String phoneNumber = scanner.nextLine();
        while (true) {
            try {
                customerImpl.setPhoneNumber(phoneNumber);
                break;
            } catch (InvalidFieldException e) {
                System.out.println(e.getMessage());
            }

            phoneNumber = scanner.nextLine();
        }
    }

    private void createCustomerAddress(CustomerImpl customerImpl, Scanner scanner) {
        System.out.println("Please enter your address:");
        System.out.println("Your address must be at the street's name and the number, separated with comma.");
        System.out.println("For Example: President Lincoln,66");
        String address = scanner.nextLine();
        while (true) {
            try {
                customerImpl.setAddress(address);
                break;
            } catch (InvalidFieldException e) {
                System.out.println(e.getMessage());
            }

            address = scanner.nextLine();
        }
    }

    private void createCustomerCity(CustomerImpl customerImpl, Scanner scanner) {
        System.out.println("Please enter your city:");
        String city = scanner.nextLine();
        while (true) {
            try {
                customerImpl.setCity(city);
                break;
            } catch (InvalidFieldException e) {
                System.out.println(e.getMessage());
            }

            city = scanner.nextLine();
        }
    }


}

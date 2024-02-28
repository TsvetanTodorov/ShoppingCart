package main.services;

import main.constants.ShoppingConstants;
import main.entities.CustomerImpl;
import main.exceptions.InvalidFieldException;

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

        printCustomerSuccessRegistration();

        return customerImpl;
    }

    private void createCustomerName(CustomerImpl customerImpl, Scanner scanner) {
        printCustomerNameInfo();
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
        printCustomerAgeInfo();
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
        printCustomerPhoneNumberInfo();
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
        printCustomerAddressInfo();
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
        printCustomerCityInfo();
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


    private void printCustomerSuccessRegistration() {
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_SUCCESSFULLY_REGISTERED]);
    }

    private void printCustomerNameInfo() {
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_ENTER_NAME]);
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_VALID_NAME_DIGITS]);
    }

    private void printCustomerAgeInfo() {
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_ENTER_AGE]);
    }

    private void printCustomerPhoneNumberInfo() {
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_ENTER_PHONE_NUMBER]);
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_VALID_PHONE_NUMBER_LENGTH]);
    }

    private void printCustomerAddressInfo() {
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_ENTER_ADDRESS]);
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_VALID_ADDRESS_ORDER]);
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_ADDRESS_EXAMPLE]);
    }

    private void printCustomerCityInfo() {
        System.out.println(ShoppingConstants.GREETINGS_VALUES[ShoppingConstants.GREETINGS_ENTER_CITY]);
    }
}

package entities;

import constants.ShoppingConstants;
import exceptions.InvalidFieldException;
import interfaces.Customer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerImpl implements Customer {

    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private String city;
    private Map<String, Product> shoppingCart = new HashMap<>();


    public CustomerImpl() {
    }

    @Override
    public void checkShoppingCart() {
        System.out.println("Products in your shopping cart:");
        for (Map.Entry<String, Product> productEntry : shoppingCart.entrySet()) {
            System.out.printf("%s , Quantity: %d\n",
                    productEntry.getValue().getName(), productEntry.getValue().getQuantity());
        }
    }

    @Override
    public void cashOut() {
        System.out.println("Your total cost is: " + calculateTotalSum());
        System.out.printf("Dear %s, Thank you for supporting my shop!", this.name);
    }

    @Override
    public void help() {
        for (int i = 0; i < ShoppingConstants.commandsArr.length; i++) {
            System.out.println("Command: " + ShoppingConstants.commandsArr[i] + "  -> " + ShoppingConstants.commandsDescription[i]);
        }
    }

    @Override
    public void buyProduct(Product product) {
        if (shoppingCart.containsKey(product.getName())) {
            Product existingProduct = shoppingCart.get(product.getName());
            existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
            existingProduct.setPrice(product.getPrice());
        } else {
            shoppingCart.put(product.getName(), product);
        }
    }

    @Override
    public void returnProduct(Product product) throws InvalidFieldException {
        if (isNotExistingProduct(product)) {
            throw new InvalidFieldException("You don't have this type of product in your shopping cart!");
        }

        int quantityToReturn = product.getQuantity();
        if (shoppingCart.get(product.getName()).getQuantity() < quantityToReturn) {
            throw new InvalidFieldException(String.format("You don't have that many Product: %s in your shopping cart\n", product.getName()));
        }

        Product existingProduct = shoppingCart.get(product.getName());
        existingProduct.setQuantity(existingProduct.getQuantity() - quantityToReturn);

        if (quantityToReturn == 1) {
            System.out.printf("Successfully returned %d %s from your shopping cart!\n",
                    quantityToReturn, product.getName());
        } else {
            System.out.printf("Successfully returned %d %ss from your shopping cart!\n",
                    quantityToReturn, product.getName());
        }

    }

    @Override
    public void info() {
        printInfo();
    }

    public void setName(String name) throws InvalidFieldException {
        if (name == null || name.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty name!");
        }

        if (isValidName(name)) {
            this.name = name;
            return;
        }


        throw new InvalidFieldException("Invalid name! Please enter a valid name:");
    }

    public void setAge(String age) throws InvalidFieldException {
        if (age == null || age.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty age!");
        }

        if (isValidAge(age)) {
            int parsedAge = Integer.parseInt(age);

            if (isAgeNotRealistic(parsedAge)) {
                throw new InvalidFieldException("You're joking right? Now tell us the real age of yours:");
            }

            this.age = parsedAge;
            return;
        }

        throw new InvalidFieldException("Invalid age! Please enter a valid age:");
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidFieldException {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty phone number!");
        }

        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return;
        }

        throw new InvalidFieldException("Invalid phone number! The length of your phone number must be 10 digits! " +
                "Please re-enter your phone number:");
    }

    public void setAddress(String address) throws InvalidFieldException {
        if (address == null || address.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty address!");
        }

        if (isValidAddress(address)) {
            this.address = address;
            return;
        }

        throw new InvalidFieldException("Invalid address! Please enter a valid address:");

    }

    public void setCity(String city) throws InvalidFieldException {
        if (city == null || city.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty city!");
        }

        if (isValidCity(city)) {
            this.city = city;
            return;
        }

        throw new InvalidFieldException("Invalid city! Please enter a valid city:");
    }

    private boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^(?:[a-zA-Z]+(?:-[a-zA-Z]+)?(?: [a-zA-Z]+)?){2,}$");
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    private boolean isValidAge(String age) {
        Pattern pattern = Pattern.compile("^(?![0]$)\\d{1,3}$");
        Matcher matcher = pattern.matcher(age);

        return matcher.matches();
    }

    private boolean isAgeNotRealistic(int age) {
        return age > 120;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    private boolean isValidAddress(String address) {
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+,\\d+$");
        Matcher matcher = pattern.matcher(address);

        return matcher.matches();
    }

    private boolean isValidCity(String city) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(city);

        return matcher.matches();
    }

    private boolean isNotExistingProduct(Product product) {
        return !shoppingCart.containsKey(product.getName());
    }

    private double calculateTotalSum() {

        double totalPrice = 0;
        for (Map.Entry<String, Product> productEntry : shoppingCart.entrySet()) {
            totalPrice += productEntry.getValue().getQuantity() * productEntry.getValue().getPrice();
        }

        BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void printInfo() {
        System.out.println();
        System.out.println("Let's get started!");
        System.out.println("Here is the list with all the commands you can use:");
        System.out.println("Buy Product -> Example: buy-milk-2");
        System.out.println("Return Product -> Example: return-milk-1");
        System.out.println("Check what's in your shopping cart: Example: check");
        System.out.println("Check what's available in the shop: Example: check all");
        System.out.println("If you want to check all these commands again just type help");
        System.out.println("But First Let's add some products to the shop! Example add-juice-10-2.50");
    }
}

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
        printShoppingCartInfo();
    }

    @Override
    public void cashOut() {
        printCashOutInfo();
    }

    @Override
    public void help() {
        printHelpCommandInfo();
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
    public Product returnProduct(Product product) throws InvalidFieldException {
        if (isNotExistingProduct(product)) {
            throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_NOT_EXISTING_PRODUCT_IN_SHOPPING_CART]);
        }

        int quantityToReturn = product.getQuantity();
        if (shoppingCart.get(product.getName()).getQuantity() < quantityToReturn) {
            throw new InvalidFieldException(String.format(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_NOT_ENOUGH_PRODUCT_IN_SHOPPING_CART], product.getName()));
        }

        Product existingProduct = shoppingCart.get(product.getName());
        Product beforeCalculationProduct = new Product(existingProduct.getName(),
                String.valueOf(existingProduct.getPrice()),
                String.valueOf(existingProduct.getQuantity()));
        existingProduct.setQuantity(existingProduct.getQuantity() - quantityToReturn);

        if (existingProduct.getQuantity() == 0) {
            shoppingCart.remove(existingProduct.getName().toLowerCase());
        }

        if (isEqualsOne(quantityToReturn)) {
            printSuccessfullyReturnedOneProduct(quantityToReturn, product);
        } else {
            printSuccessfullyReturnedManyProducts(quantityToReturn, product);
        }

        return beforeCalculationProduct;
    }

    @Override
    public void info() {
        printInfo();
    }

    public void setName(String name) throws InvalidFieldException {
        if (isNullOrBlank(name)) {
            throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_NAME]);
        }

        if (isValidName(name)) {
            this.name = name;
            return;
        }


        throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                [ShoppingConstants.CUSTOMER_DATA_INFO_INVALID_NAME_ENTER_VALID_NAME]);
    }

    public void setAge(String age) throws InvalidFieldException {
        if (isNullOrBlank(age)) {
            throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_AGE]);
        }

        if (isValidAge(age)) {
            int parsedAge = Integer.parseInt(age);

            if (isAgeNotRealistic(parsedAge)) {
                throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                        [ShoppingConstants.CUSTOMER_DATA_INFO_TELL_US_YOUR_REAL_AGE]);
            }

            this.age = parsedAge;
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                [ShoppingConstants.CUSTOMER_DATA_INFO_INVALID_AGE_ENTER_VALID_AGE]);
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidFieldException {
        if (isNullOrBlank(phoneNumber)) {
            throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_PHONE_NUMBER]);
        }

        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                [ShoppingConstants.CUSTOMER_DATA_INFO_INVALID_PHONE_NUMBER_THE_LENGTH_MUST_BE_10_DIGITS]
                + ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                [ShoppingConstants.CUSTOMER_DATA_INFO_RE_ENTER_PHONE_NUMBER]);
    }

    public void setAddress(String address) throws InvalidFieldException {
        if (isNullOrBlank(address)) {
            throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_ADDRESS]);
        }

        if (isValidAddress(address)) {
            this.address = address;
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                [ShoppingConstants.CUSTOMER_DATA_INFO_INVALID_ADDRESS_ENTER_VALID_ADDRESS]);
    }

    public void setCity(String city) throws InvalidFieldException {
        if (isNullOrBlank(city)) {
            throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                    [ShoppingConstants.CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_CITY]);
        }

        if (isValidCity(city)) {
            this.city = city;
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES
                [ShoppingConstants.CUSTOMER_DATA_INFO_INVALID_CITY_ENTER_VALID_CITY]);
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

    private void printHelpCommandInfo() {
        for (int i = 0; i < ShoppingConstants.commandsArr.length; i++) {
            System.out.println("Command: " + ShoppingConstants.commandsArr[i] + "  -> " + ShoppingConstants.commandsDescription[i]);
        }
    }

    private void printShoppingCartInfo() {
        System.out.println(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES[ShoppingConstants.CUSTOMER_DATA_INFO_PRODUCTS_IN_CART]);
        for (Map.Entry<String, Product> productEntry : shoppingCart.entrySet()) {
            System.out.printf("%s , Quantity: %d\n",
                    productEntry.getValue().getName(), productEntry.getValue().getQuantity());
        }
    }

    private void printCashOutInfo() {
        System.out.println(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES[ShoppingConstants.CUSTOMER_DATA_INFO_TOTAL_COST]
                + calculateTotalSum());
        System.out.printf(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES[ShoppingConstants.CUSTOMER_DATA_INFO_THANKS_FOR_THE_SUPPORT]
                , this.name);
    }

    private boolean isEqualsOne(int quantityToReturn) {
        return quantityToReturn == 1;
    }

    private void printSuccessfullyReturnedOneProduct(int quantityToReturn, Product product) {
        System.out.printf(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES[ShoppingConstants.CUSTOMER_DATA_INFO_SUCCESSFULLY_RETURNED_PRODUCT],
                quantityToReturn, product.getName());
    }

    private void printSuccessfullyReturnedManyProducts(int quantityToReturn, Product product) {
        System.out.printf(ShoppingConstants.CUSTOMER_DATA_INFO_VALUES[ShoppingConstants.CUSTOMER_DATA_INFO_SUCCESSFULLY_RETURNED_PRODUCTS],
                quantityToReturn, product.getName());
    }

    private boolean isNullOrBlank(String currentValue) {
        return currentValue == null || currentValue.isBlank();
    }


}


package entities;

import constants.ShoppingConstants;
import exceptions.InvalidFieldException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, String price, String quantity) throws InvalidFieldException {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public Product(String name, String quantity) throws InvalidFieldException {
        setName(name);
        setQuantity(quantity);
    }


    public void setName(String name) throws InvalidFieldException {
        validateProductName(name);
        this.name = name;
    }

    public void setPrice(String price) throws InvalidFieldException {
        validateProductPrice(price);
        this.price = Double.parseDouble(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(String quantity) throws InvalidFieldException {
        validateProductQuantity(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    private boolean isNotValidName(String name) {
        Pattern pattern = Pattern.compile("^(?:[a-zA-Z]+(?:-[a-zA-Z]+)?(?: [a-zA-Z]+)?)$");
        Matcher matcher = pattern.matcher(name);

        return !matcher.matches();
    }

    private boolean isNotValidPrice(String price) {
        Pattern pattern = Pattern.compile("^\\d+(?:\\.\\d{1,2})?$");
        Matcher matcher = pattern.matcher(price);

        return !matcher.matches();
    }

    private boolean isNotValidQuantity(String quantity) {
        Pattern pattern = Pattern.compile("^(?![0]$)\\d{1,4}$");
        Matcher matcher = pattern.matcher(quantity);

        return !matcher.matches();
    }

    private boolean isNullOrBlank(String currentValue) {
        return currentValue == null || currentValue.isBlank();
    }

    private void validateProductName(String name) throws InvalidFieldException {
        if (isNullOrBlank(name)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_NAME]);
        }

        if (isNotValidName(name)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_INVALID_PRODUCT_NAME]);
        }
    }

    private void validateProductPrice(String price) throws InvalidFieldException {
        if (isNullOrBlank(price)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_PRICE]);
        }

        if (isNotValidPrice(price)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_INVALID_PRODUCT_PRICE]);
        }
    }

    private void validateProductQuantity(String quantity) throws InvalidFieldException {
        if (isNullOrBlank(quantity)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_QUANTITY]);
        }

        if (isNotValidQuantity(quantity)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_INVALID_PRODUCT_QUANTITY]);
        }
    }
}

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
        if (isNullOrBlank(name)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_NAME]);
        }

        if (isValidName(name)) {
            this.name = name;
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                [ShoppingConstants.PRODUCT_DATA_INFO_INVALID_PRODUCT_NAME]);
    }

    public void setPrice(String price) throws InvalidFieldException {
        if (isNullOrBlank(price)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_PRICE]);
        }

        if (isValidPrice(price)) {
            this.price = Double.parseDouble(price);
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                [ShoppingConstants.PRODUCT_DATA_INFO_INVALID_PRODUCT_PRICE]);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(String quantity) throws InvalidFieldException {
        if (isNullOrBlank(quantity)) {
            throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                    [ShoppingConstants.PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_QUANTITY]);
        }

        if (isValidQuantity(quantity)) {
            this.quantity = Integer.parseInt(quantity);
            return;
        }

        throw new InvalidFieldException(ShoppingConstants.PRODUCT_DATA_INFO_VALUES
                [ShoppingConstants.PRODUCT_DATA_INFO_INVALID_PRODUCT_QUANTITY]);
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

    private boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^(?:[a-zA-Z]+(?:-[a-zA-Z]+)?(?: [a-zA-Z]+)?)$");
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    private boolean isValidPrice(String price) {
        Pattern pattern = Pattern.compile("^\\d+(?:\\.\\d{1,2})?$");
        Matcher matcher = pattern.matcher(price);

        return matcher.matches();
    }

    private boolean isValidQuantity(String quantity) {
        Pattern pattern = Pattern.compile("^(?![0]$)\\d{1,4}$");
        Matcher matcher = pattern.matcher(quantity);

        return matcher.matches();
    }

    private boolean isNullOrBlank(String currentValue) {
        return currentValue == null || currentValue.isBlank();
    }
}

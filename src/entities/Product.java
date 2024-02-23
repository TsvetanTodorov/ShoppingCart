package entities;

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
        if (name == null || name.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty name of the product!");
        }

        if (isValidName(name)) {
            this.name = name;
            return;
        }

        throw new InvalidFieldException("Invalid product name! Please enter a valid product name:");
    }

    public void setPrice(String price) throws InvalidFieldException {
        if (price == null || price.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty price for the product!");
        }

        if (isValidPrice(price)) {
            this.price = Double.parseDouble(price);
            return;
        }

        throw new InvalidFieldException("Invalid product price! Please enter a valid product price:");
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(String quantity) throws InvalidFieldException {
        if (quantity == null || quantity.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty product quantity!");
        }

        if (isValidQuantity(quantity)) {
            this.quantity = Integer.parseInt(quantity);
            return;
        }

        throw new InvalidFieldException("Invalid product quantity! Please enter a valid product quantity:");
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
}

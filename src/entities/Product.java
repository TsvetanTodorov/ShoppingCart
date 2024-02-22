package entities;

import exceptions.InvalidFieldException;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) throws InvalidFieldException {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, int quantity) throws InvalidFieldException {
        this.name = name;
        this.quantity = quantity;
    }


}

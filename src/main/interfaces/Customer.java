package main.interfaces;

import main.entities.Product;
import main.exceptions.InvalidFieldException;

public interface Customer {

    void checkShoppingCart();

    void cashOut();

    void help();

    void buyProduct(Product product);

    Product returnProduct(Product product) throws InvalidFieldException;

    void info();




}

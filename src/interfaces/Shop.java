package interfaces;

import entities.Product;
import exceptions.InvalidFieldException;

public interface Shop {

    void addProduct(Product product) throws InvalidFieldException;

    void buyProduct(Product product) throws InvalidFieldException;

    void returnProduct(Product product);

    void checkProductAvailability(String name);

    void checkAllProductsAvailability();
}

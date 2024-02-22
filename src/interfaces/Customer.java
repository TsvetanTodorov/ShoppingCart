package interfaces;

import entities.Product;

public interface Customer {

    void checkShoppingCart();

    void cashOut();

    void help();

    void buyProduct(Product product);

    void returnProduct(Product product);




}

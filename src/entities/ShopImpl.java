package entities;

import constants.ShoppingConstants;
import exceptions.InvalidFieldException;
import interfaces.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopImpl implements Shop {

    private Map<String, Product> products = new HashMap<>();

    public ShopImpl() throws InvalidFieldException {
        products.put("milk", new Product("milk", "2.50", "10"));
        products.put("bread", new Product("bread", "1.50", "15"));
        products.put("egg", new Product("egg", "0.50", "100"));
    }

    @Override
    public void addProduct(Product newProduct) throws InvalidFieldException {
        String newProductName = newProduct.getName();

        if (products.containsKey(newProductName)) {
            setNewProductInfo(newProduct);
        } else {
            products.put(newProductName, newProduct);
        }

        System.out.printf(ShoppingConstants.SHOP_DATA_INFO_VALUES
                        [ShoppingConstants.SHOP_DATA_INFO_SUCCESSFULLY_ADDED_PRODUCT],
                newProductName, newProduct.getQuantity(), newProduct.getPrice());
    }

    @Override
    public void buyProduct(Product productToBuy) throws InvalidFieldException {
        if (isNotExistingProduct(productToBuy)) {
            throw new InvalidFieldException(ShoppingConstants.SHOP_DATA_INFO_VALUES
                    [ShoppingConstants.SHOP_DATA_INFO_UNAVAILABLE_PRODUCT]);
        }

        String productToBuyName = productToBuy.getName();
        Product existingProduct = products.get(productToBuyName.toLowerCase());

        if (hasEnoughQuantity(existingProduct, productToBuy)) {
            throw new InvalidFieldException(ShoppingConstants.SHOP_DATA_INFO_VALUES
                    [ShoppingConstants.SHOP_DATA_INFO_NOT_ENOUGH_QUANTITY] + productToBuyName);
        }

        existingProduct.setQuantity(existingProduct.getQuantity() - productToBuy.getQuantity());
        if (existingProduct.getQuantity() == 0) {
            products.remove(existingProduct.getName().toLowerCase());
        }

        if (productToBuy.getQuantity() == 1) {
            System.out.printf(ShoppingConstants.SHOP_DATA_INFO_VALUES
                            [ShoppingConstants.SHOP_DATA_INFO_SUCCESSFULLY_ADDED_PRODUCT_TO_SHOPPING_CART],
                    productToBuy.getQuantity(), productToBuyName);
        } else {
            System.out.printf(ShoppingConstants.SHOP_DATA_INFO_VALUES
                            [ShoppingConstants.SHOP_DATA_INFO_SUCCESSFULLY_ADDED_PRODUCTS_TO_SHOPPING_CART],
                    productToBuy.getQuantity(), productToBuyName);
        }
        System.out.println(ShoppingConstants.SHOP_DATA_INFO_VALUES
                [ShoppingConstants.SHOP_DATA_INFO_ANYTHING_ELSE_TO_BUY]);

    }

    @Override
    public void returnProduct(Product product) {
        if (isNotExistingProduct(product)) {
            products.put(product.getName(), product);
        } else {
            String productToAdd = product.getName();
            int quantityToAdd = product.getQuantity();
            Product currentProduct = products.get(productToAdd.toLowerCase());

            int totalQuantity = quantityToAdd + currentProduct.getQuantity();

            currentProduct.setQuantity(totalQuantity);
        }
    }

    @Override
    public void checkProductAvailability(String name) {
        if (products.containsKey(name)) {
            Product currentProduct = products.get(name);
            System.out.printf(ShoppingConstants.SHOP_DATA_INFO_VALUES
                            [ShoppingConstants.SHOP_DATA_INFO_AVAILABLE_PRODUCT_QUANTITY],
                    name, currentProduct.getQuantity());
        } else {
            System.out.printf(ShoppingConstants.SHOP_DATA_INFO_VALUES
                    [ShoppingConstants.SHOP_DATA_INFO_UNAVAILABLE_PRODUCT_BY_NAME], name);
        }
    }

    @Override
    public void checkAllProductsAvailability() {
        System.out.println(ShoppingConstants.SHOP_DATA_INFO_VALUES
                [ShoppingConstants.SHOP_DATA_INFO_ALL_AVAILABLE_PRODUCTS]);
        for (Map.Entry<String, Product> productEntry : products.entrySet()) {
            System.out.printf(ShoppingConstants.SHOP_DATA_INFO_VALUES
                            [ShoppingConstants.SHOP_DATA_INFO_PRODUCT_NAME_PRICE_QUANTITY],
                    productEntry.getValue().getName(), productEntry.getValue().getPrice(), productEntry.getValue().getQuantity());
        }
    }

    private void setNewProductInfo(Product newProduct) {
        Product currentProduct = products.get(newProduct.getName().toLowerCase());

        int totalQuantity = newProduct.getQuantity() + currentProduct.getQuantity();
        double totalCost = (newProduct.getPrice() * newProduct.getQuantity())
                + (currentProduct.getPrice() * currentProduct.getQuantity());
        double averagePrice = totalCost / totalQuantity;

        currentProduct.setQuantity(totalQuantity);
        currentProduct.setPrice(averagePrice);
    }

    private boolean isNotExistingProduct(Product product) {
        return !products.containsKey(product.getName());
    }

    private boolean hasEnoughQuantity(Product existingProduct, Product productToBuy) {
        int quantityToBuy = productToBuy.getQuantity();

        return existingProduct.getQuantity() < quantityToBuy;
    }

    public Product getProduct(String productName) {
        if (products.containsKey(productName)) {
            return products.get(productName);
        }

        return null;
    }
}

package entities;

import exceptions.InvalidFieldException;
import interfaces.Shop;

import java.util.HashMap;
import java.util.Map;

public class ShopImpl implements Shop {

    private Map<String, Product> products = new HashMap<>();

    public ShopImpl() throws InvalidFieldException {
        products.put("milk", new Product("Milk", "2.50", "10"));
        products.put("bread", new Product("Bread", "1.50", "15"));
        products.put("egg", new Product("Egg", "0.50", "100"));
    }

    @Override
    public void addProduct(Product newProduct) throws InvalidFieldException {
        String newProductName = newProduct.getName();

        if (products.containsKey(newProductName)) {
            setNewProductInfo(newProduct);
        } else {
            products.put(newProductName, newProduct);
        }

        System.out.printf("Successfully added the product: %s, with quantity: %d and price: %.2f to the shop!\n",
                newProductName, newProduct.getQuantity(), newProduct.getPrice());
    }

    @Override
    public void buyProduct(Product productToBuy) throws InvalidFieldException {
        if (isExistingProduct(productToBuy)) {
            throw new InvalidFieldException("Sorry we don't have this product in the shop!");
        }

        String productToBuyName = productToBuy.getName();
        Product existingProduct = products.get(productToBuyName.toLowerCase());

        if (hasEnoughQuantity(existingProduct, productToBuy)) {
            throw new InvalidFieldException("Sorry we don't have that many " + productToBuyName);
        }

        existingProduct.setQuantity(existingProduct.getQuantity() - productToBuy.getQuantity());

        System.out.printf("You successfully added %s to your shopping cart!\n", productToBuyName);
        System.out.println("Would you like to buy anything else ?");
    }

    @Override
    public void returnProduct(Product product) {
        if (isExistingProduct(product)) {
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
            System.out.printf("Yes! We have the product: %s, with %d available quantity!\n",
                    name, currentProduct.getQuantity());
        } else {
            System.out.printf("Sorry! We don't have the product: %s\n", name);
        }
    }

    @Override
    public void checkAllProductsAvailability() {

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

    private boolean isExistingProduct(Product product) {
        return !products.containsKey(product.getName());
    }

    private boolean hasEnoughQuantity(Product existingProduct, Product productToBuy) {
        int quantityToBuy = productToBuy.getQuantity();

        return existingProduct.getQuantity() < quantityToBuy;
    }
}

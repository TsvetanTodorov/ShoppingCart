package constants;

public interface ShoppingConstants {

    String[] commandsArr = {
            "add",
            "buy",
            "return",
            "check",
            "check all",
            "help",
            "cash out"
    };

    String[] commandsDescription = {
            "Add some products to the shop -> Example add-juice-10-2.50",
            "Buy Product -> Example: buy-milk-2",
            "Return Product -> Example: return-milk-1",
            "Check what's in your shopping cart -> Example: check",
            "Check what's available in the shop -> Example: check all",
            "If you want to check all these commands again just type help",
            "If you're done with your shopping type cash out"
    };


    int GREETINGS_SUCCESSFULLY_REGISTERED = 0;
    int GREETINGS_ENTER_NAME = 1;
    int GREETINGS_VALID_NAME_DIGITS = 2;
    int GREETINGS_ENTER_AGE = 3;
    int GREETINGS_ENTER_PHONE_NUMBER = 4;
    int GREETINGS_VALID_PHONE_NUMBER_LENGTH = 5;
    int GREETINGS_ENTER_ADDRESS = 6;
    int GREETINGS_VALID_ADDRESS_ORDER = 7;
    int GREETINGS_ADDRESS_EXAMPLE = 8;
    int GREETINGS_ENTER_CITY = 9;


    String[] GREETINGS_VALUES = {
            "Your registration was created successfully!",
            "Please enter your name:",
            "Your name should be at least 2 digits long!",
            "Please enter your age:",
            "Please enter your phone number:",
            "The length of your phone number must be 10 digits!",
            "Please enter your address:",
            "Your address must be the street's name and the number, separated with comma.",
            "For Example: President Lincoln,66",
            "Please enter your city:"
    };


    int CUSTOMER_DATA_INFO_PRODUCTS_IN_CART = 0;
    int CUSTOMER_DATA_INFO_TOTAL_COST = 1;
    int CUSTOMER_DATA_INFO_THANKS_FOR_THE_SUPPORT = 2;
    int CUSTOMER_DATA_INFO_NOT_EXISTING_PRODUCT_IN_SHOPPING_CART = 3;
    int CUSTOMER_DATA_INFO_NOT_ENOUGH_PRODUCT_IN_SHOPPING_CART = 4;
    int CUSTOMER_DATA_INFO_SUCCESSFULLY_RETURNED_PRODUCT = 5;
    int CUSTOMER_DATA_INFO_SUCCESSFULLY_RETURNED_PRODUCTS = 6;
    int CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_NAME = 7;
    int CUSTOMER_DATA_INFO_INVALID_NAME_ENTER_VALID_NAME = 8;
    int CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_AGE = 9;
    int CUSTOMER_DATA_INFO_TELL_US_YOUR_REAL_AGE = 10;
    int CUSTOMER_DATA_INFO_INVALID_AGE_ENTER_VALID_AGE = 11;
    int CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_PHONE_NUMBER = 12;
    int CUSTOMER_DATA_INFO_INVALID_PHONE_NUMBER_THE_LENGTH_MUST_BE_10_DIGITS = 13;
    int CUSTOMER_DATA_INFO_RE_ENTER_PHONE_NUMBER = 14;
    int CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_ADDRESS = 15;
    int CUSTOMER_DATA_INFO_INVALID_ADDRESS_ENTER_VALID_ADDRESS = 16;
    int CUSTOMER_DATA_INFO_CANNOT_ENTER_EMPTY_CITY = 17;
    int CUSTOMER_DATA_INFO_INVALID_CITY_ENTER_VALID_CITY = 18;


    String[] CUSTOMER_DATA_INFO_VALUES = {
            "Products in your shopping cart:",
            "Your total cost is: ",
            "Dear %s, Thank you for supporting my shop!",
            "You don't have this type of product in your shopping cart!",
            "You don't have that many Product: %s in your shopping cart\n",
            "Successfully returned %d %s from your shopping cart!\n",
            "Successfully returned %d %ss from your shopping cart!\n",
            "You cannot enter an empty name!",
            "Invalid name! Please enter a valid name:",
            "You cannot enter an empty age!",
            "You're joking right? Now tell us the real age of yours:",
            "Invalid age! Please enter a valid age:",
            "You cannot enter an empty phone number!",
            "Invalid phone number! The length of your phone number must be 10 digits! ",
            "Please re-enter your phone number:",
            "You cannot enter an empty address!",
            "Invalid address! Please enter a valid address:",
            "You cannot enter an empty city!",
            "Invalid city! Please enter a valid city:"
    };


    int SHOP_DATA_INFO_SUCCESSFULLY_ADDED_PRODUCT = 0;
    int SHOP_DATA_INFO_UNAVAILABLE_PRODUCT = 1;
    int SHOP_DATA_INFO_NOT_ENOUGH_QUANTITY = 2;
    int SHOP_DATA_INFO_SUCCESSFULLY_ADDED_PRODUCT_TO_SHOPPING_CART = 3;
    int SHOP_DATA_INFO_SUCCESSFULLY_ADDED_PRODUCTS_TO_SHOPPING_CART = 4;
    int SHOP_DATA_INFO_ANYTHING_ELSE_TO_BUY = 5;
    int SHOP_DATA_INFO_AVAILABLE_PRODUCT_QUANTITY = 6;
    int SHOP_DATA_INFO_UNAVAILABLE_PRODUCT_BY_NAME = 7;
    int SHOP_DATA_INFO_ALL_AVAILABLE_PRODUCTS = 8;
    int SHOP_DATA_INFO_PRODUCT_NAME_PRICE_QUANTITY = 9;

    String[] SHOP_DATA_INFO_VALUES = {
            "Successfully added the product: %s, with quantity: %d and price: %.2f to the shop!\n",
            "Sorry we don't have this product in the shop!",
            "Sorry we don't have that many ",
            "You successfully added %d %s to your shopping cart!\n",
            "You successfully added %d %ss to your shopping cart!\n",
            "Would you like to buy anything else ?",
            "Yes! We have the product: %s, with %d available quantity!\n",
            "Sorry! We don't have the product: %s\n",
            "Available products in the shop:",
            "%s , Price: %.2f, Quantity: %d\n"
    };


    int PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_NAME = 0;
    int PRODUCT_DATA_INFO_INVALID_PRODUCT_NAME = 1;
    int PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_PRICE = 2;
    int PRODUCT_DATA_INFO_INVALID_PRODUCT_PRICE = 3;
    int PRODUCT_DATA_INFO_CANNOT_ENTER_EMPTY_QUANTITY = 4;
    int PRODUCT_DATA_INFO_INVALID_PRODUCT_QUANTITY = 5;

    String[] PRODUCT_DATA_INFO_VALUES = {
            "You cannot enter an empty name of the product!",
            "Invalid product name! Please enter a valid product name:",
            "You cannot enter an empty price for the product!",
            "Invalid product price! Please enter a valid product price:",
            "You cannot enter an empty product quantity!",
            "Invalid product quantity! Please enter a valid product quantity:"
    };

}

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
            "Add some products to the shop! Example add-juice-10-2.50",
            "Buy Product -> Example: buy-milk-2",
            "Return Product -> Example: return-milk-1",
            "Check what's in your shopping cart: Example: check",
            "Check what's available in the shop: Example: check all",
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

    String[] CUSTOMER_DATA_INFO_VALUES = {
            "Products in your shopping cart:",
            "Your total cost is: ",
            "Dear %s, Thank you for supporting my shop!",
            "You don't have this type of product in your shopping cart!",
            "You don't have that many Product: %s in your shopping cart\n",
            "Successfully returned %d %s from your shopping cart!\n",
            "Successfully returned %d %ss from your shopping cart!\n"

    };


}

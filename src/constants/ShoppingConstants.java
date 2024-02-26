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

}

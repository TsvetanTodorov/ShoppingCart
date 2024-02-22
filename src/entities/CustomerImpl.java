package entities;

import exceptions.InvalidFieldException;
import interfaces.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerImpl implements Customer {

    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private String city;
    private List<Product> shoppingCart = new ArrayList<>();


    public CustomerImpl() {
    }

    @Override
    public void checkShoppingCart() {

    }

    @Override
    public void cashOut() {

    }

    @Override
    public void help() {

    }

    @Override
    public void buyProduct(Product product) {

    }

    @Override
    public void returnProduct(Product product) {

    }

    public void setName(String name) throws InvalidFieldException {
        if (name == null || name.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty name!");
        }

        if (isValidName(name)) {
            this.name = name;
            return;
        }

        throw new InvalidFieldException("Invalid name! Please enter a valid name:");
    }

    public void setAge(String age) throws InvalidFieldException {
        if (age == null || age.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty age!");
        }

        if (isValidAge(age)) {
            int parsedAge = Integer.parseInt(age);

            if (isAgeNotRealistic(parsedAge)) {
                throw new InvalidFieldException("You're joking right? Now tell us the real age of yours:");
            }

            this.age = parsedAge;
        }

        throw new InvalidFieldException("Invalid age! Please enter a valid age:");
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidFieldException {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty phone number!");
        }

        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return;
        }

        throw new InvalidFieldException("Invalid phone number! The length of your phone number must be 10 digits!" +
                "Please re-enter your phone number:");
    }

    public void setAddress(String address) throws InvalidFieldException {
        if (address == null || address.isBlank()) {
            throw new InvalidFieldException("Ypu cannot enter an empty address!");
        }

        if (isValidAddress(address)) {
            this.address = address;
            return;
        }

        throw new InvalidFieldException("Invalid address! Please enter a valid address:");

    }

    public void setCity(String city) throws InvalidFieldException {
        if (city == null || city.isBlank()) {
            throw new InvalidFieldException("You cannot enter an empty city!");
        }

        if (isValidCity(city)) {
            this.city = city;
            return;
        }

        throw new InvalidFieldException("Invalid city! Please enter a valid city:");
    }

    private boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^(?:[a-zA-Z]+(?:-[a-zA-Z]+)?(?: [a-zA-Z]+)?)$");
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    private boolean isValidAge(String age) {
        Pattern pattern = Pattern.compile("^(?![0]$)\\d{1,3}$");
        Matcher matcher = pattern.matcher(age);

        return matcher.matches();
    }

    private boolean isAgeNotRealistic(int age) {
        return age > 120;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    private boolean isValidAddress(String address) {
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+,\\d+$");
        Matcher matcher = pattern.matcher(address);

        return matcher.matches();
    }

    private boolean isValidCity(String city) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(city);

        return matcher.matches();
    }
}

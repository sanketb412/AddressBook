package com.address;

public class AddressBook {

    /** Address Book inputs**/
    /** defining Strings and int **/
    String firstName,lastName,address,city,state,eMail,phoneNumber;
    int zip;

    /** Defining each elements **/
    public AddressBook (String firstName,String lastName,String address,String city,String state,
                        int zip,String eMail, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }
    /** Printing the Elements **/
    public void addressBook() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Email Address: " + eMail);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public static void main (String[] args) {
        System.out.println("Welcome to Address Book Program in AddressBook in Main Class");
        AddressBook book = new AddressBook(null,null,null,null,null,0,null,null);
        book.addressBook();
    }
}

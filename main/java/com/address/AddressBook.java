package com.address;

import java.util.Scanner;

public class AddressBook {

    /** Address Book inputs**/
    /** defining Strings and int **/
    String firstName,lastName,address,city,state,eMail,phoneNumber;
    int zip;

    /** Defining each elements **/
    public  AddressBook (String firstName,String lastName,String address,String city,String state,
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

    public AddressBook() {

    }
    /** Getting input from User **/
    private void addContactDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name");
        String First_Name = sc.nextLine();
        System.out.println("Enter the Last Name");
        String Last_Name = sc.nextLine();
        System.out.println("Enter the Address");
        String Address = sc.nextLine();
        System.out.println("Enter the City");
        String City = sc.nextLine();
        System.out.println("Enter the State");
        String State = sc.nextLine();
        System.out.println("Enter the Zip Code");
        int zip = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Contact Number");
        String Contact_Number = sc.nextLine();
        System.out.println("Enter the Email address");
        String eMail = sc.nextLine();
        /** Calling addressBook **/
        AddressBook entry = new AddressBook(First_Name, Last_Name, Address, City, State, zip, Contact_Number, eMail);
        entry.addressBook();
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
        AddressBook book = new AddressBook();
        book.addContactDetails();  /** Calling addContactDetails **/
    }
}

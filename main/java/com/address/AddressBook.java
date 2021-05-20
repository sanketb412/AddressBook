package com.address;


import java.util.Scanner;

public class AddressBook {
    /**
     * Creating method for getting input from user
     */
    void addContactDetails () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter the Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter the Address");
        String address = sc.nextLine();
        System.out.println("Enter the City");
        String city = sc.nextLine();
        System.out.println("Enter the State");
        String state = sc.nextLine();
        System.out.println("Enter the Zip Code");
        int zipCode = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Email address");
        String eMail = sc.nextLine();
        System.out.println("Enter the Phone Number");
        String phoneNumber = sc.nextLine();

        ContactPerson contact = new ContactPerson(firstName,lastName,address,city,state,zipCode,eMail,phoneNumber);
        contact.addressBook();
    }

    public static void main (String[] args) {
        System.out.println("Welcome to Address Book Program in AddressBook in Main Class");
        AddressBook contact = new AddressBook();
        contact.addContactDetails(); /** Calling addContactDetail method **/
    }

}


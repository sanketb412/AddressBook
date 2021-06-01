package com.address;

import java.util.*;
import java.util.stream.Collectors;

public class AddressMain {
    private static AddressBook addressBook = new AddressBook();
    static Scanner sc = new Scanner(System.in); //initializing scanner class
    public static Map<String, AddressBook> addressBookListMap = new HashMap<String, AddressBook>();//initializing hashmap
    /**
    check if the address book already there or not
     */
    public static void main(String[] args) {
        AddressMain addressBookMain = new AddressMain();
        System.out.println("Welcome to Address Book System");
        boolean flag = true;//declaring flag
        while (flag) {
            System.out.println("1: Add new address book");
            System.out.println("2:Find Duplicate Entry in Address Book");
            System.out.println("3.Search Contact from a city");
            System.out.println("4.Search Contact from a State");
            System.out.println("5.View contact By State Using");
            System.out.println("6.View Contact by city Using");
            System.out.println("7.Count Contact By State");
            System.out.println("8.Count Contact By City");
            System.out.println("9.Exit");
            int option = sc.nextInt();
            switch (option) {//getting option from user
                case 1:
                    System.out.println("Enter the name of the address book");
                    String addressBookName = sc.next();
                    if (addressBookListMap.containsKey(addressBookName)) {
                        System.out.println("this address book already exists ");
                        break;
                    } else {
                        addAddressBook(addressBookName);
                        break;
                    }
                case 2:
                    for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                        AddressBook value = entry.getValue();
                        System.out.println("Address Book Name: " + entry.getKey());
                        value.checkDuplicate();
                    }
                case 3:
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                    addressBookMain.searchPersonByCity(CityName);
                    break;

                case 4:
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addressBookMain.searchPersonByState(StateName);
                    break;
                case 5:
                    System.out.println("Enter Name of State: ");
                    String stateName1 = sc.next();
                    addressBookMain.viewPersonByStateUsingHashmap(stateName1);
                    break;

                case 6:
                    System.out.println("Enter Name of City: ");
                    String cityName1 = sc.next();
                    addressBookMain.viewPersonByCityUsingHashMap(cityName1);
                    break;

                case 7:
                    System.out.println("Enter Name of State: ");
                    String stateName2 = sc.next();
                    addressBookMain.CountByState(stateName2);
                    break;

                case 8:
                    System.out.println("Enter Name of City: ");
                    String cityName2 = sc.next();
                    addressBookMain.CountByCity(cityName2);
                    break;

                case 9:
                    flag = false;
                    break;
            }
        }
    }
    /**
    addAddressBook method to add,edit and delete in address book
     */
    private static void addAddressBook(String addressBookName) {
        boolean flag = true;
        while(flag) {
            System.out.println("Enter 1 to add contact: ");
            System.out.println("Enter 2 to edit contact: ");
            System.out.println("Enter 3 to delete contact: ");
            System.out.println("Enter 4 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.editContact();
                    break;
                case 3:
                    addressBook.deleteContact();
                    break;
                case 4:
                    flag = !flag;
                    break;
                default:
                    System.out.println("Please Enter valid number");
                    break;
            }
        }
        addressBookListMap.put(addressBookName, addressBook);
        System.out.println("Address Book Added Successfully");
    }
    private void searchPersonByState(String stateName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    private void searchPersonByCity(String cityName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }

    private void viewPersonByStateUsingHashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactPerson> contacts = value.personByState.entrySet().stream().filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactPerson contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastName());
            }
        }
    }

    private void viewPersonByCityUsingHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactPerson> contacts = value.personByCity.entrySet().stream().filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for (ContactPerson contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }

    public void CountByState(String state) {
        int count = 0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet()){
            for(int i=0;i<(entry.getValue()).person.size();i++)
            {
                ContactPerson contact= entry.getValue().person.get(i);

                if(state.equals(contact.getState()))
                {
                    count++;
                }

            }
        }
        System.out.println("Total Person Count in state "+state+": "+count);
    }
    public void CountByCity(String city) {
        int count = 0;
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            for (int i = 0; i < (entry.getValue()).person.size(); i++) {
                ContactPerson d = (ContactPerson) entry.getValue().person.get(i);

                if (city.equals(d.getCity())) {
                    count++;
                }

            }
        }
        System.out.println("Total number of people in this city " + city + ": " + count);
    }
    private void sortContactByName() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.person.stream().sorted(Comparator.comparing(ContactPerson::getFirstName)).collect(Collectors.toList());

            for (ContactPerson contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
            }
        }
    }
}

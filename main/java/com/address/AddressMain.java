package com.address;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.address.AddressBook.person;

public class AddressMain<CsvValidationException extends Throwable> {
    private static AddressBook addressBook = new AddressBook();
    static Scanner sc = new Scanner(System.in); //initializing scanner class
    public static Map<String, AddressBook> addressBookListMap = new HashMap<String, AddressBook>();//initializing hashmap
    /**
    check if the address book already there or not
     */
    public static void main(String[] args) throws FileNotFoundException {
        AddressMain addressBookMain = new AddressMain();
        System.out.println("Welcome to Address Book System");
//        boolean flag = true;//declaring flag
//        while (flag) {
//            System.out.println("1: Add new address book");
//            System.out.println("2:Find Duplicate Entry in Address Book");
//            System.out.println("3.Search Contact from a city");
//            System.out.println("4.Search Contact from a State");
//            System.out.println("5.View contact By State Using");
//            System.out.println("6.View Contact by city Using");
//            System.out.println("7.Count Contact By State");
//            System.out.println("8.Count Contact By City");
//            System.out.println("9.Exit");
//            int option = sc.nextInt();
//            switch (option) {//getting option from user
//                case 1:
//                    System.out.println("Enter the name of the address book");
//                    String addressBookName = sc.next();
//                    if (addressBookListMap.containsKey(addressBookName)) {
//                        System.out.println("this address book already exists ");
//                        break;
//                    } else {
//                        addAddressBook(addressBookName);
//                        break;
//                    }
//                case 2:
//                    for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
//                        AddressBook value = entry.getValue();
//                        System.out.println("Address Book Name: " + entry.getKey());
//                        value.checkDuplicate();
//                    }
//                case 3:
//                    System.out.println("Enter Name of City: ");
//                    String CityName = sc.next();
//                    addressBookMain.searchPersonByCity(CityName);
//                    break;
//
//                case 4:
//                    System.out.println("Enter Name of State: ");
//                    String StateName = sc.next();
//                    addressBookMain.searchPersonByState(StateName);
//                    break;
//                case 5:
//                    System.out.println("Enter Name of State: ");
//                    String stateName1 = sc.next();
//                    addressBookMain.viewPersonByStateUsingHashmap(stateName1);
//                    break;
//
//                case 6:
//                    System.out.println("Enter Name of City: ");
//                    String cityName1 = sc.next();
//                    addressBookMain.viewPersonByCityUsingHashMap(cityName1);
//                    break;
//
//                case 7:
//                    System.out.println("Enter Name of State: ");
//                    String stateName2 = sc.next();
//                    addressBookMain.CountByState(stateName2);
//                    break;
//
//                case 8:
//                    System.out.println("Enter Name of City: ");
//                    String cityName2 = sc.next();
//                    addressBookMain.CountByCity(cityName2);
//                    break;
//
//                case 9:
//                    System.out.println("Sort Contact");
//                    addressBookMain.sortContactByName();
//
//                case 10:
//                    addressBookMain.sortContactByCity();
//                    break;
//
//                case 11:
//                    addressBookMain.sortContactByState();
//                    break;
//
//                case 12:
//                    addressBookMain.sortContactByZipCode();
//                    break;
//
//                case 13:
//                    flag = false;
//                    break;
//            }
//        }
//        addressBookMain.fileRead();
//        addressBookMain.CSVRead();
        String First_Name = "ASEA";
        String Last_Name = "SYGA";
        String Address = "SHHHEEE";
        String City = "Maha";
        String State = "Mauala";
        int ZipCode = 8475435;
        long Phone_number = 2134243434;
        String EmailID = "sakerwjm@gjans.comn";
//        addressBookMain.CSVWrite(First_Name,Last_Name,Address,City,State,ZipCode,Phone_number,EmailID);


        /**
         * calling writeDataFromJSON Method into main
         */
        try {
            addressBookMain.writeDataInJSon(First_Name,Last_Name,Address,City,State,ZipCode,Phone_number,EmailID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * calling readDataFromJSON Method into main
         */
        try {
            addressBookMain.readDataFromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
    addAddressBook method to add,edit and delete in address book
     */
    private static void addAddressBook(String addressBookName) {
        boolean flag = true;
        while(flag) {
            System.out.println("Enter 1 to Add contact: ");
            System.out.println("Enter 2 to Edit contact: ");
            System.out.println("Enter 3 to Delete contact: ");
            System.out.println("Enter 4 to Exit");
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
            List<ContactPerson> sortedList = person.stream().sorted(Comparator.comparing(ContactPerson::getFirstName)).collect(Collectors.toList());

            for (ContactPerson contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
            }
        }
    }
    private void sortContactByZipCode() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = person.stream().sorted(Comparator.comparing(ContactPerson::getZipCode)).collect(Collectors.toList());

            for(ContactPerson contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastName());
            }
        }
    }

    private void sortContactByState() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = person.stream().sorted(Comparator.comparing(ContactPerson::getState)).collect(Collectors.toList());

            for(ContactPerson contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastName());
            }
        }
    }

    private void sortContactByCity() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = person.stream().sorted(Comparator.comparing(ContactPerson::getCity)).collect(Collectors.toList());

            for (ContactPerson contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
            }
        }
    }

    /**
     * Reaeding file from Address.txt file
     * @throws FileNotFoundException
     */

    private void fileRead() throws FileNotFoundException {
        File file = new File("E:\\ideaproject\\AddressBook\\src\\main\\resources\\Address.txt");
        Scanner fileSC = new Scanner(file);

        while(fileSC.hasNextLine()){
            System.out.println(fileSC.nextLine());
        }
    }
    /**
     * Reading file from contacts_details.csv
     */
    private void CSVRead() {
        String path = "E:\\ideaproject\\AddressBook\\src\\main\\resources\\contacts_detail.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writing file into contacts_details.csv
     */
    public void CSVWrite(String First_Name,String Last_Name,String Address,String City,String State,int ZipCode,long Phone_number,String EmailID){
        try {
            String filepath = "E:\\ideaproject\\AddressBook\\src\\main\\resources\\contacts_detail.csv";
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.print("\n"+First_Name+","+Last_Name+","+Address+","+City+","+State+","+ZipCode+","+Phone_number+","+EmailID);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null,"Record saved");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Record not saved");
        }
    }

    /**
     * Reading Contacts from JSON file
     * @throws IOException
     */
    public void readDataFromJson() throws IOException {
        ArrayList<ContactPerson> contactList;
        Path filePath = Paths.get(
                                  "E:\\ideaproject\\AddressBook\\src\\main\\resources\\Contacts.json");
        try (Reader reader = Files.newBufferedReader(filePath);) {
            Gson gson = new Gson();
            contactList = new ArrayList<ContactPerson>(Arrays.asList(gson.fromJson(reader, ContactPerson[].class)));
            for (ContactPerson contact : contactList) {
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("Address : " + contact.getAddress());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip : " + contact.getZipCode());
                System.out.println("Phone number : " + contact.getPhoneNumber());
                System.out.println("Email : " + contact.getEmail());
            }
        }

    }

    /**
     * Write into JSON file
     */
    public void writeDataInJSon(String First_Name,String Last_Name,String Address,String City,String State,int ZipCode,long Phone_number,String EmailID) throws IOException {
        {
            Path filePath = Paths.get(
                                      "E:\\ideaproject\\AddressBook\\src\\main\\resources\\Contacts.json");
            Gson gson = new Gson();
            String json = gson.toJson(person);
            FileWriter writer = new FileWriter(String.valueOf(filePath));
            writer.write(json);
            writer.close();
        }
    }
}

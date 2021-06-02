package com.address;

public class ContactPerson {

    String firstName,lastName,address,city,state,email;
    int zipCode;
    long phoneNumber;
    public ContactPerson(String firstName, String lastName, String address, String city, String state, int zipCode, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    /**
    getter and setter methods
     */
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
    public String getAddress() {

        return address;
    }
    public void setAddress(String address) {

        this.address = address;
    }
    public String getCity() {

        return city;
    }
    public void setCity(String city) {

        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {

        this.state = state;
    }
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
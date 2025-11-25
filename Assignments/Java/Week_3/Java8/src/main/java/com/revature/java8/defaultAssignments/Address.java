package com.revature.java8.defaultAssignments;

public class Address {
    private String houseNum;
    private String street;
    private String city;
    private String zip;

    public Address() {

    }

    public Address( String houseNum, String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.houseNum = houseNum;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address: " + houseNum + " " + street +", " + city + ", " + zip;
    }
}

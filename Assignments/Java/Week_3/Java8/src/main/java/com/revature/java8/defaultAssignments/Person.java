package com.revature.java8.defaultAssignments;

public class Person {
    private String name;
    private String phoneNum;
    private Address address;

    public Person() {
    }

    public Person(String name, String phoneNum, Address address) {
        this.address = address;
        this.phoneNum = phoneNum;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address=" + address +
                '}';
    }
}

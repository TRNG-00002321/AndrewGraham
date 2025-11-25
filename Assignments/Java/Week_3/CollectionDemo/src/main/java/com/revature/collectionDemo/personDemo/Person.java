package com.revature.collectionDemo.personDemo;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String ID;
    private String name;
    private double salary;

    public Person() {
    }

    public Person(String ID, String name, double age) {
        this.ID = ID;
        this.name = name;
        this.salary = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        return this.ID.compareTo(other.ID);
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person u1, Person u2) {
        return u1.getName().compareTo(u2.getName());
    }
}

class SalaryComparator implements Comparator<Person> {
    @Override
    public int compare(Person u1, Person u2) {
        return Double.compare(u1.getSalary(), u2.getSalary());
    }
}





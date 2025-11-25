package com.revature.collectionDemo.personDemo;
import java.util.*;
public class PersonList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> employees = new ArrayList<Person>();


        employees.add(new Person("e5", "Andrew", 50000));
        employees.add(new Person("e2", "John", 60000));
        employees.add(new Person("e3", "Adam", 55000));
        employees.add(new Person("e4", "Matt", 75000));
        employees.add(new Person("e1", "Charlie", 55000));

        employees.sort(new NameComparator());
        System.out.println("Sorted by Name:");
        for(Person p : employees)
            System.out.println(p);
        System.out.println("Sorted by ID:");
        Collections.sort(employees);
        for(Person p : employees)
            System.out.println(p);
        System.out.println("Sorted by Salary:");
        employees.sort(new SalaryComparator());
        for(Person p : employees)
            System.out.println(p);



    }
}

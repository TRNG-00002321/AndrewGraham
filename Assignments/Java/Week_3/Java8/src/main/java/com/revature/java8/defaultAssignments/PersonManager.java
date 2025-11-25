package com.revature.java8.defaultAssignments;

import java.util.Optional;

public class PersonManager {

    public static void main(String[] args) {
        Address a1 = new Address("1234", "Elm St", "Dallas","70007");
        Person p1 = new Person("Andrew","972-123-9865", a1);
        Person p2 = new Person("John", "214-012-9001", new Address());

        Optional<String> checkNull = Optional.ofNullable(p2.getAddress().getStreet());

        System.out.println(p1);
        if(checkNull.isPresent())
            System.out.println(p2);
        else
            System.out.println("Person does not have an Address");
    }
}

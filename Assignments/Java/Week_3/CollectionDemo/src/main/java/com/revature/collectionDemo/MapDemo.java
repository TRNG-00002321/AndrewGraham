package com.revature.collectionDemo;
import java.util.*;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, Double> people = new HashMap<String, Double>();


        people.put("Andrew", 10000.00);
        people.put("John", 15000.00);
        people.put("Bob", 20000.00);

        System.out.println(people.get("John"));

        Set<String> names= people.keySet();
        for(String name : names)
            System.out.println(name + ": " +people.get(name));

    }
}

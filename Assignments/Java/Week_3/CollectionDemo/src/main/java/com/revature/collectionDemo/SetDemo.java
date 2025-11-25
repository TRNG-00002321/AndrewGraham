package com.revature.collectionDemo;
import java.util.*;

public class SetDemo {

    public static void main(String[] args) {

        //Set<String> names = new HashSet<String>();
        Set<String> names = new TreeSet<String>();
        //Set<String> names = new LinkedHashSet<String>();

        Set<String> otherNames = new LinkedHashSet<>();
        otherNames.add("Elvis");
        otherNames.add("Tom");

        names.add("Andrew");
        names.add("Steve");
        names.add("Jacob");
        names.add("John");

        names.addAll(otherNames);



        System.out.println(names);

        for (String str : names)
            System.out.println(str);

    }
}

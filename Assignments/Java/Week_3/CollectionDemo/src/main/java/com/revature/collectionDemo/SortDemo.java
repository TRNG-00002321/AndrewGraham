package com.revature.collectionDemo;

import java.util.ArrayList;
import java.util.*;

public class SortDemo {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();

        names.add("Andrew");
        names.add("Steve");
        names.add("Bob");
        names.add("Alex");

        Collections.sort(names);

        //implement a reverse sort

        System.out.println(names);




    }
}

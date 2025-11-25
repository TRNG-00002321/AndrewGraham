package com.revature.collectionDemo;
import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
        List myList = new ArrayList();
        myList.add(1);
        myList.add("hello");
        myList.add(2.4);
        myList.add(0, "test");

        System.out.println(myList.get(0));
        Iterator iterator = myList.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        for(int i = 0; i < myList.size(); i++)
            System.out.println(myList.get(i));

        for(Object i : myList)
            System.out.println(i);




    }
}

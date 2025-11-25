package com.revature.collectionDemo;
import java.util.*;
public class LinkedListDemo {

    public static void main(String[] args) {

        List linkedList = new LinkedList();

        List linkedList2 = new LinkedList();

        linkedList.add("hello");
        linkedList.add("world");
        Iterator iter = linkedList.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        System.out.println();
        linkedList2.addAll(linkedList);
        for(Object i : linkedList2)
            System.out.println(i);
        linkedList.clear();
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.contains("hello"));

        System.out.println(linkedList2.contains("hello"));
        linkedList.add("hello");
        for(Object i : linkedList2)
            System.out.println(i);
        System.out.println();
        linkedList2.removeAll(linkedList);
        for(Object i : linkedList2)
            System.out.println(i);


    }

}

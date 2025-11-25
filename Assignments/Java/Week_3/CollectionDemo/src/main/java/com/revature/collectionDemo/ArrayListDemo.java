package com.revature.collectionDemo;
import java.util.*;
public class ArrayListDemo {

    public static void main(String[] args) {

        List arrayList = new ArrayList();

        List arrayList2 = new ArrayList();

        arrayList.add("hello");
        arrayList.add("world");
        Iterator iter = arrayList.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        System.out.println();
        arrayList2.addAll(arrayList);
        for(Object i : arrayList2)
            System.out.println(i);
        arrayList.clear();
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains("hello"));

        System.out.println(arrayList2.contains("hello"));
        arrayList.add("hello");
        for(Object i : arrayList2)
            System.out.println(i);
        System.out.println();
        arrayList2.removeAll(arrayList);
        for(Object i : arrayList2)
            System.out.println(i);


    }

}

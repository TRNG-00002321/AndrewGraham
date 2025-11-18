package com.revature;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Andrew", "agraham", "password");
        Set<Manager> managers = new TreeSet<Manager>();
        managers.add(manager);
        System.out.println(manager.Login("agraham", "password"));
        System.out.println(managers);




    }
}
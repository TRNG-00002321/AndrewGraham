package com.revature;
import com.revature.model.Manager;
import com.revature.service.ManagerService;
import com.revature.utils.ConnectionUtil;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Manager manager = new Manager("Andrew", "agraham", "password");
//        Manager manager1 = new Manager("Aaron", "aagraham", "password123");
//        Set<Manager> managers = new TreeSet<Manager>();
//        managers.add(manager);
//
//        boolean added = managers.add(manager1);
//        System.out.println("Was new manager added?: " + added);
//        System.out.println(manager.Login("agraham", "password"));
//        System.out.println(managers);
//        Connection connection = ConnectionUtil.dbConnection();


        ManagerService managerService = new ManagerService();

        Manager manager = managerService.getManager("manager1");

        System.out.println(manager);
    }
}
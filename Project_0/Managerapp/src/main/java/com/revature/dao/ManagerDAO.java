package com.revature.dao;



import com.revature.model.Manager;

import java.util.*;

public interface ManagerDAO {

    public List<Manager> getAllManagers();


    public Manager getManager(String username);

    public Manager login();

    public void signup();

    public List<String> getUsernames();

    public List<ArrayList<Object>> getExpenses();

    public List<ArrayList<Object>> getEmployeeExpenses();

    public List<ArrayList<Object>> getPendingExpenses();

    public void manageExpenses(String managerUsername);

    public List<Object> generateReport();

    public void logout();

    public List<ArrayList<Object>> getProcessedExpenses();
}
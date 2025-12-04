package com.revature.service;

import com.revature.dao.ManagerDAO;
import com.revature.dao.ManagerJDBC;
import com.revature.model.Manager;
import java.util.*;

public class ManagerService {


    public Manager getManager(String username){

        ManagerDAO managerDAO = new ManagerJDBC();


        return managerDAO.getManager(username);


    }

    public Manager login(){


        ManagerDAO managerDAO = new ManagerJDBC();


        return managerDAO.login();
    }

    public void signup() {
        ManagerDAO managerDAO = new ManagerJDBC();


        managerDAO.signup();
    }

    public List<ArrayList<Object>> getExpenses(){
        ManagerDAO managerDAO = new ManagerJDBC();


       return managerDAO.getExpenses();

    }

    public List<ArrayList<Object>> getEmployeeExpenses(){
        ManagerDAO managerDAO = new ManagerJDBC();


        return managerDAO.getEmployeeExpenses();

    }

    public List<ArrayList<Object>> getPendingExpenses(){
        ManagerDAO managerDAO = new ManagerJDBC();


        return managerDAO.getPendingExpenses();

    }

    public void manageExpenses(String managerUsername){
        ManagerDAO managerDAO = new ManagerJDBC();

        managerDAO.manageExpenses(managerUsername);
    }

    public List<Object> generateReport(){
        ManagerDAO managerDAO = new ManagerJDBC();


        return managerDAO.generateReport();

    }

    public void logout(){
        ManagerDAO managerDAO = new ManagerJDBC();

        managerDAO.logout();
    }

    public List<ArrayList<Object>> getProcessedExpenses(){
        ManagerDAO managerDAO = new ManagerJDBC();

        return managerDAO.getProcessedExpenses();
    }


}

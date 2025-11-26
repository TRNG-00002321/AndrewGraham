package com.revature.service;

import com.revature.dao.ManagerDAO;
import com.revature.dao.ManagerJDBC;
import com.revature.model.Manager;

public class ManagerService {


    public Manager getManager(String username){

        ManagerDAO managerDAO = new ManagerJDBC();


        return managerDAO.getManager(username);


    }
}

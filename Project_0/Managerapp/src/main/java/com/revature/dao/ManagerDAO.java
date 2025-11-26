package com.revature.dao;



import com.revature.model.Manager;

import java.util.List;

public interface ManagerDAO {

    public List<Manager> getAllManagers();


    public Manager getManager(String username);

    public void save(Manager manager);

    public Manager update(String username);

    public void delete(String username);

}
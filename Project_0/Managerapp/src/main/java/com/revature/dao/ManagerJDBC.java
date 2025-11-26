package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.revature.model.Manager;
import com.revature.utils.ConnectionUtil;

public class ManagerJDBC implements ManagerDAO {

    Connection connection = null;

    @Override
    public List<Manager> getAllManagers() {
        return List.of();
    }

    @Override
    public  Manager getManager(String username) {
        connection = ConnectionUtil.dbConnection();
        String getManagerQ = "select * from managers where username = ?";
        Manager managers = new Manager();
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(getManagerQ);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                managers = new Manager(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return managers;
    }

    @Override
    public void save(Manager manager) {

    }

    @Override
    public Manager update(String username) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}

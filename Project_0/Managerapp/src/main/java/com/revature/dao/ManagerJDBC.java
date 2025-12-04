package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.model.Manager;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.TableOutput;
import de.vandermeer.asciitable.AsciiTable;

public class ManagerJDBC implements ManagerDAO {

    Connection connection = ConnectionUtil.dbConnection();
    Scanner scanner = new Scanner(System.in);

    private static final Logger logger = LoggerFactory.getLogger(ManagerJDBC.class);

    @Override
    public List<Manager> getAllManagers() {
        return List.of();
    }

    @Override
    public  Manager getManager(String username) {

        String getManagerQ = "select * from managers where username = ?";
        Manager manager = new Manager();
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(getManagerQ);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                manager = new Manager(resultSet.getString(2), resultSet.getString(1), resultSet.getString(3));
            }

        } catch (SQLException e) {
            logger.error("invalid sql query");
            throw new RuntimeException(e);
        }
        logger.info("got manager");
        return manager;
    }

    public Manager login(){

        Manager manager = new Manager();
        String inputName = "";
        while(manager.getUsername() == null) {
            System.out.println("Enter your username: ");
            inputName = scanner.nextLine();
            if(inputName.equals("-1"))
                break;
            manager = getManager(inputName);
            if(manager.getUsername() == null)
                System.out.println("Incorrect Username");

        }
        if(inputName.equals("-1"))
            return null;
        String UserPassword = manager.getPassword();
        int counter = 2;
        System.out.println("Enter your password: ");
        String inputPassword = scanner.nextLine();
        while(!inputPassword.equals(UserPassword) && counter >0){
            System.out.println("Incorrect Password. " + counter + " Incorrect Attempts Remaining");
            System.out.println("Enter your password: ");
            inputPassword = scanner.nextLine();

            counter--;
        }
        if(inputPassword.equals(UserPassword)) {
            System.out.println("Login Successful");
            return manager;
        }
        System.out.println("Login Unsuccessful");
        return null;
    }

    @Override
    public void signup() {
        List<String> usernames = getUsernames();
        System.out.println("Enter your username: ");
        String inputUsername = scanner.nextLine();

        boolean usernameExists = true;
        while(usernameExists){
            for(String username : usernames) {
                if(inputUsername.equals("-1")) {
                    System.out.println("Canceled");
                    return;
                }
                if (inputUsername.equals(username)) {
                    System.out.println("Username already exists. Try again.");
                    System.out.println("Enter your username: ");
                    inputUsername = scanner.nextLine();
                    usernameExists = true;
                    break;
                } else
                    usernameExists = false;
                continue;
            }

        }
        System.out.println("Enter your name: ");
        String inputName = scanner.nextLine();
        if(inputName.equals("-1")) {
            System.out.println("Canceled");
            return;
        }
        String inputPassword = "";
        do {
            System.out.println("Enter your password: ");
            inputPassword = scanner.nextLine();
            if(inputPassword.equals("-1")) {
                System.out.println("Canceled");
                return;
            }
            if(inputPassword.length()<5)
                System.out.println("Password is too short");
        }while(inputPassword.length()<5);


        try {
            String insertQuery = "insert into managers values(?,?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, inputUsername);
            preparedStatement.setString(2, inputName);
            preparedStatement.setString(3, inputPassword);
            int rowsAffected = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<String> getUsernames() {
        String usernames = "select username from managers";
        List<String> allUsernames = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(usernames);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUsernames.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsernames;
    }

    @Override
    public List<ArrayList<Object>> getExpenses() {
        List<ArrayList<Object>> expenses = new ArrayList<>();
        String getExpensesQ = "select exp_id, emp_username, expense, exp_cost, exp_desc, exp_date, exp_status, categories.category from expenses join categories on exp_category=id";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(getExpensesQ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expenses.add(new ArrayList<>(List.of(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getDouble(4),
                            resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expenses;
    }
    @Override
    public List<ArrayList<Object>> getProcessedExpenses(){
        List<ArrayList<Object>> expenses = new ArrayList<>();
        String getExpensesQ = "select expenses.expense, expenses.emp_username, manager_username, expenses.exp_status, comments from processed_expenses join expenses on expenses.exp_id = processed_expenses.exp_id";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(getExpensesQ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expenses.add(new ArrayList<>(List.of(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expenses;
    }

    public List<ArrayList<Object>> getEmployeeExpenses() {
        List<ArrayList<Object>> expenses = new ArrayList<>();
        List<String> empUsernames = getEmployeeUsernames();
        String getExpensesQ = "select exp_id, emp_username, expense, exp_cost, exp_desc, exp_date, exp_status, categories.category from expenses join categories on exp_category=id where emp_username = ?";

        System.out.println("All employee usernames:");
        for(String name : empUsernames)
            System.out.println(name);
        System.out.println("Enter the employee username");
        String username = scanner.nextLine();
        boolean validUsername = false;
        while(!validUsername){
            for(String name : empUsernames){
                if(username.equals(name)) {
                    validUsername = true;
                    break;
                }


            }
            if(!validUsername){
                System.out.println("Employee does not exist.");
                System.out.println("Enter the employee username");
                username = scanner.nextLine();
            }
        }
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(getExpensesQ);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                expenses.add(new ArrayList<>(List.of(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getDouble(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8))));
            }
            if(expenses.isEmpty())
                System.out.println("No expenses from " + username);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expenses;
    }

    @Override
    public List<ArrayList<Object>> getPendingExpenses() {
        List<ArrayList<Object>> expenses = new ArrayList<>();
        String getExpensesQ = "select exp_id, emp_username, expense, exp_cost, exp_desc, exp_date, exp_status, categories.category from expenses join categories on exp_category=id where exp_status = 'Pending'";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(getExpensesQ);
            ResultSet resultSet = preparedStatement.executeQuery();
//            if(!resultSet.next()) {
//                System.out.println("No expenses pending");
//                return expenses;
//            }
            while (resultSet.next()) {
                expenses.add(new ArrayList<>(List.of(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getDouble(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expenses;
    }



    public List<String> getEmployeeUsernames() {
        connection = ConnectionUtil.dbConnection();
        String usernames = "select username from employees";
        List<String> allUsernames = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(usernames);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUsernames.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsernames;
    }


    @Override
    public void manageExpenses(String managerUsername) {
        AsciiTable table = new AsciiTable();
        TableOutput tableOutput = new TableOutput();
        List<ArrayList<Object>> pendingExpenses = getPendingExpenses();
        if(pendingExpenses.isEmpty())
            return;
        tableOutput.printExpenseTable(table, pendingExpenses);
        System.out.println("Enter the expense id number you want to update:");
        int inputExpense = -1;
        try{inputExpense = scanner.nextInt();}
        catch(InputMismatchException e){
            System.out.println("Invalid entry");
        }
        if(inputExpense == -1){
            System.out.println("Canceled");
            return;
        }

        for(ArrayList<Object> expense : pendingExpenses){
            if(inputExpense == (Integer)expense.get(0)) {
                System.out.println("What would you like to do?");
                System.out.println("1. Approve");
                System.out.println("2. Deny");
                scanner.nextLine();
                String task = scanner.nextLine();
                if(task.equals("1"))
                    approveExpense(inputExpense, (String)expense.get(1), managerUsername);
                else if(task.equals("2"))
                    denyExpense(inputExpense, (String)expense.get(1), managerUsername);
                else
                    System.out.println("Task Canceled");
                //make new tables denials and approvals
                //add id and comments to new tables
                break;
            }


        }


    }

    public void approveExpense(int expenseID, String empUsername, String managerUsername){
        String updateQ = "update expenses set exp_status = 'Approved' where exp_id = ?";
        String comments = "insert into processed_expenses (exp_id, emp_username, manager_username, exp_status, comments) values(?, ?, ?, 'Approved', ?)";
        System.out.println("Provide feedback on approving this expense");
        String feedback = scanner.nextLine();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(updateQ);
            preparedStatement.setInt(1, expenseID);

            int rowsAffected = preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 =preparedStatement = connection.prepareStatement(comments);
            preparedStatement1.setInt(1, expenseID);
            preparedStatement1.setString(2, empUsername);
            preparedStatement1.setString(3,managerUsername);
            preparedStatement1.setString(4, feedback);

            int rowsAffected1 = preparedStatement1.executeUpdate();
            logger.info("Expense approved");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void denyExpense(int expenseID, String empUsername, String managerUsername){
        String updateQ = "update expenses set exp_status = 'Denied' where exp_id = ?";
        String comments = "insert into processed_expenses (exp_id, emp_username, manager_username, exp_status, comments) values(?, ?, ?, 'Denied', ?)";
        System.out.println("Provide feedback on approving this expense");
        String feedback = scanner.nextLine();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(updateQ);
            preparedStatement.setInt(1, expenseID);

            int rowsAffected = preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 =preparedStatement = connection.prepareStatement(comments);
            preparedStatement1.setInt(1, expenseID);
            preparedStatement1.setString(2, empUsername);
            preparedStatement1.setString(3,managerUsername);
            preparedStatement1.setString(4, feedback);

            int rowsAffected1 = preparedStatement1.executeUpdate();
            logger.info("Expense approved");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> generateReport(){
        List<Object> report = new ArrayList<>();

        System.out.println("How would you like to generate a report");
        System.out.println("1. By Date Range");
        System.out.println("2. By Category");
        System.out.println("3. By Employee");
        System.out.println("4. By Status");
        System.out.println("5. Cancel");
        String task = scanner.nextLine();
        switch(task){
            case "1":
                report = dateReport();
                break;
            case "2":
                report = categoryReport();
                break;
            case "3":
                report = employeeReport();
                break;
            case "4":
                report = statusReport();
                break;
            case "5":

                break;
            default:
                System.out.println("Invalid input");
        }

        return report;
    }

    public void logout(){
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Object> dateReport(){
        List<Object> report = new ArrayList<>();
        String dateRegex = "\\d{4}-\\d{2}-\\d{2}";
        String startDate = "", endDate = "";
        while(!startDate.matches(dateRegex)) {
            System.out.println("Enter the start date (YYYY-MM-DD)");
            startDate = scanner.nextLine();
        }
        while(!endDate.matches(dateRegex)) {
            System.out.println("Enter the end date (YYYY-MM-DD)");
            endDate = scanner.nextLine();
        }

        String reportQ = "select count(expense), sum(exp_cost) from expenses where exp_date BETWEEN ? AND ?";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(reportQ);
            preparedStatement.setString(1, startDate);
            preparedStatement.setString(2, endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
//            if(!resultSet.next()) {
//                System.out.println("No expenses pending");
//                return expenses;
//            }
            while (resultSet.next()) {

                //String result2 = resultSet.getString(1);
                //Double result3 = resultSet.getDouble(2);

                report.add(resultSet.getString(1));
                report.add(resultSet.getDouble(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return report;
    }

    public List<Object> categoryReport(){
        List<Object> report = new ArrayList<>();

        List<String> categories = getCategories();

        for(int i = 1; i <= categories.size(); i ++)
            System.out.println(i + ". " + categories.get(i-1));


        System.out.println("Enter the category id to sort by: ");
        int category = 0;
        try{
            category = scanner.nextInt();
            while(category<1 || category >5) {
                System.out.println("Invalid id");
                System.out.println("Enter the category id to sort by: ");
                category = scanner.nextInt();
            }

        } catch(InputMismatchException e){
            System.out.println("Invalid id");
        }


        String reportQ = "select category, count(expense), sum(exp_cost) from expenses join categories on id=exp_category where exp_category = ?";


        try {
            PreparedStatement preparedStatement= connection.prepareStatement(reportQ);
            preparedStatement.setInt(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
//            if(!resultSet.next()) {
//                System.out.println("No expenses pending");
//                return expenses;
//            }
            while (resultSet.next()) {


                report.add(resultSet.getString(1));
                report.add(resultSet.getInt(2));
                report.add(resultSet.getDouble(3));
                report.add("category");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return report;
    }

    public List<Object> employeeReport(){
        List<Object> report = new ArrayList<>();
        List<String> usernames = getEmployeeUsernames();

        System.out.println("All employee usernames:");
        for(String name : usernames)
            System.out.println(name);
        System.out.println("Enter the employee username");
        String username = scanner.nextLine();
        boolean validUsername = false;
        while(!validUsername){
            for(String name : usernames){
                if(username.equals(name)) {
                    validUsername = true;
                    break;
                }
            }
            if(!validUsername){
                System.out.println("Employee does not exist.");
                System.out.println("Enter the employee username");
                username = scanner.nextLine();
            }
        }
        String reportQ = "select emp_username, count(expense), sum(exp_cost) from expenses where emp_username = ? and exp_status = 'Approved'";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(reportQ);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                report.add(resultSet.getString(1));
                report.add(resultSet.getInt(2));
                report.add(resultSet.getDouble(3));
                report.add("employee");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return report;
    }

    public List<Object> statusReport(){
        List<Object> report = new ArrayList<>();
        String[] statuses = {"Pending", "Approved", "Denied"};
        for(int i = 1; i <= statuses.length; i++)
            System.out.println(i + ". " + statuses[i-1]);
        System.out.println("Enter the status to sort by (1-3):");
        String inputStatus = scanner.nextLine();
        boolean validStatus = false;
        while(!validStatus){
            if(inputStatus.equals("1")){
                validStatus = true;
                inputStatus = "Pending";
            }
            else if(inputStatus.equals("2")){
                validStatus = true;
                inputStatus = "Approved";
            }
            else if(inputStatus.equals("3")){
                validStatus = true;
                inputStatus = "Denied";
            }
            if(!validStatus){
                System.out.println("Status does not exist.");
                System.out.println("Enter the status to sort by (1-3):");
                inputStatus = scanner.nextLine();
            }
        }
        String reportQ = "select exp_status, count(expense), sum(exp_cost) from expenses where exp_status = ?";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(reportQ);
            preparedStatement.setString(1, inputStatus);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                report.add(resultSet.getString(1));
                report.add(resultSet.getInt(2));
                report.add(resultSet.getDouble(3));
                report.add("status");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return report;
    }

    public List<String> getCategories(){
        List<String> categories = new ArrayList<>();
        String categoryQ = "select category from categories";
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(categoryQ);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

}

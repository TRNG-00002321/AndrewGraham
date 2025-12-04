package com.revature;
import com.revature.dao.ManagerJDBC;
import com.revature.model.Manager;
import com.revature.service.ManagerService;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import com.revature.utils.TableOutput;
import org.slf4j.*;

import java.io.IOException;
import java.util.*;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("-----Activity Started-----");

        Scanner scanner = new Scanner(System.in);
        TableOutput tableOutput = new TableOutput();

        ManagerService managerService = new ManagerService();
        Manager manager = new Manager();
        String input = "";
        boolean loggedIn = false;
        while (!input.equals("3") && !loggedIn) {
            System.out.println("What would you like to do? (1-3)\n1. Login \n2. Sign Up \n3. Exit");
            input = scanner.nextLine();
            if (input.equals("1")) {
                logger.info("login attempt");
                manager = managerService.login();
                if (manager != null) {
                    loggedIn = true;
                    String logInfo = manager.getUsername() + " logged in successfully";
                    logger.info(logInfo);
                }

            } else if (input.equals("2")) {
                logger.info("signup attempt");
                managerService.signup();
            }

        }
        //change for easy debugging
        while (loggedIn) {
            AsciiTable table = new AsciiTable();

            System.out.println("What would you like to do? (1-7)");
            System.out.println("1. View all expenses");
            System.out.println("2. View processed expenses");
            System.out.println("3. View specific users expenses");
            System.out.println("4. View all pending expenses");
            System.out.println("5. Approve/Deny expenses");
            System.out.println("6. Generate Report");
            System.out.println("7. Logout");
            String task = scanner.nextLine();
            List<ArrayList<Object>> arr;
            switch (task) {
                case "1": //view all expenses
                    arr = managerService.getExpenses();

                    tableOutput.printExpenseTable(table, arr);
                    logger.info("viewed all expenses");
                    break;
                case "2":
                    arr = managerService.getProcessedExpenses();
                    logger.info("viewed processed expenses");
                    tableOutput.printProcessedTable(table, arr);
                    break;
                case "3": //view specific users expenses
                    arr = managerService.getEmployeeExpenses();
                    logger.info("viewed employee expenses");
                    tableOutput.printExpenseTable(table, arr);

                    break;
                case "4": //view pending expenses
                    arr = managerService.getPendingExpenses();
                    logger.info("viewed pending expenses");
                    tableOutput.printExpenseTable(table, arr);
                    break;
                case "5": //approve/deny expenses
                    managerService.manageExpenses(manager.getUsername());
                    logger.info("managed expenses");
                    break;
                case "6": //generate report
                    List<Object> report = managerService.generateReport();
                    logger.info("generated report");
                    if (report.size() == 2)
                        tableOutput.printDateReport(table, report);
                    else
                        tableOutput.printReport(table, report);
                    break;
                case "7": //logout
                    loggedIn = false;
                    managerService.logout();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }


        }


        logger.info("-----Activity Ended-----");
    }

}
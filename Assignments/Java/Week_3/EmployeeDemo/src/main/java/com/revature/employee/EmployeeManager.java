package com.revature.employee;
import java.util.Scanner;

public class EmployeeManager {

    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is your name?");
            String name = scanner.next();
            System.out.println("Salaried or Contractual? (type 's' or 'c')");
            System.out.println("Or type exit");
            String type = scanner.next();
            int time;
            if (type.equals("S") || type.equals("s")) {
                System.out.println("Enter number of days worked:");
                time = scanner.nextInt();
                SalariedEmployee salariedEmployee = new SalariedEmployee(name, time);
                salariedEmployee.CalculatePay();
                label:
                while(true){
                    System.out.println("What would you like to do?");
                    System.out.println("View employee info or view benefits? (type 'i' or 'b')");
                    System.out.println("Or type done");
                    String action = scanner.next();
                    switch (action) {
                        case "i":
                        case "I":
                            System.out.println(salariedEmployee);
                            break;
                        case "b":
                        case "B":
                            salariedEmployee.viewBenefits();
                            break;
                        case "done":
                            break label;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }

                }
            } else if (type.equals("C") || type.equals("c")) {
                System.out.println("Enter number of hours worked:");
                time = scanner.nextInt();
                ContractualEmployee contractualEmployee = new ContractualEmployee(name, time);
                contractualEmployee.CalculatePay();
                System.out.println(contractualEmployee);
            }
            else if (type.equals("exit"))
                break;
            else
                System.out.println("Please try again");




        }
    }
}

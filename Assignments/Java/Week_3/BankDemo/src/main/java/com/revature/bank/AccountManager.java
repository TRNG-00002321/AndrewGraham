package com.revature.bank;
import java.util.Scanner;

public class AccountManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account ID");
        String ID = scanner.next();
        System.out.println("Enter Name");
        String name = scanner.next();
        System.out.println("Enter Starting Balance");
        double balance = scanner.nextDouble();
        System.out.println("Enter Type ('s' or 'c')");
        String type = scanner.next();
        SavingsAccount savings1 = new SavingsAccount();
        CheckingAccount checking1 = new CheckingAccount();

        if (type.equals("s"))
            savings1 = new SavingsAccount(ID, name, balance);
        else if (type.equals("c"))
            checking1 = new CheckingAccount(ID, name, balance);
        else
            System.out.println("invalid Input");;
        label:
        while(true) {
        System.out.println("Deposit (d), Withdrawl (w), view (v), or exit (q)");
        String task = scanner.next();
        double amount;
        switch(task){
            case "d":
                System.out.println("Enter Deposit Amount");
                amount = scanner.nextDouble();
                if(type.equals("s"))
                    savings1.deposit(amount);
                else
                    checking1.deposit(amount);
                break;
            case "w":
                System.out.println("Enter Withdrawl Amount");
                amount = scanner.nextDouble();
                if(type.equals("s"))
                    try {
                        savings1.withdrawal(amount);
                    }
                    catch(WithdrawalException e ){
                        e.printStackTrace();
                    }
                else
                    try {
                        checking1.withdrawal(amount);
                    }
                    catch(WithdrawalException e ){
                        e.printStackTrace();
                    }
                break;
            case "v":
                if(type.equals("s"))
                    System.out.println(savings1);
                else
                    System.out.println(checking1);
                break;
            case "q":
                break label;
            default:
                System.out.println("Invalid Input");
                break;
            }
        }

    }
}

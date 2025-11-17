package com.revature.bank;

public abstract class BankAccount {

    private String accountID;
    private String accountName;
    private double balance;


    public BankAccount() {
    }

    public BankAccount(String accountID, String accountName, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID='" + accountID + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) throws ArithmeticException{
        if(amount < 0)
            throw new ArithmeticException("Negative input");
        else
            return balance+= amount;
    }

    public abstract double withdrawal(double amount) throws WithdrawalException, ArithmeticException;
}

package com.revature.bank;

public class CheckingAccount extends BankAccount{

    public CheckingAccount() {
    }

    public CheckingAccount(String accountID, String accountName, double balance) {
        super(accountID, accountName, balance);
    }
    @Override
    public String toString() {
        return "Checking Account{" + super.toString() + "}";
    }

    @Override
    public double withdrawal(double amount) throws ArithmeticException, WithdrawalException{
        if(amount<0)
            throw new ArithmeticException("Negative input");
        if(amount >getBalance())
            throw new ArithmeticException("Not Enough Money");
        if(getBalance()<5000)
            throw new WithdrawalException("Insufficient balance");

        double surcharge = (amount*.01)/100;
        amount+=surcharge;
        setBalance(getBalance()-amount);
        return getBalance();
    }


}

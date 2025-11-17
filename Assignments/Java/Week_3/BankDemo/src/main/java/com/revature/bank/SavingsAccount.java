package com.revature.bank;

public class SavingsAccount extends BankAccount implements SimpleInterest{

    public SavingsAccount() {
    }

    public SavingsAccount(String accountID, String accountName, double balance) {
        super(accountID, accountName, balance);
    }

    @Override
    public String toString() {
        return "Savings Account{" + super.toString() + "}";
    }

    @Override
    public double withdrawal(double amount) throws ArithmeticException, WithdrawalException {
        if(amount<0)
            throw new ArithmeticException("Negative input");
        if(amount >getBalance())
            throw new ArithmeticException("Not Enough Money");
        if(getBalance()<5000)
            throw new WithdrawalException("Insufficient balance");
        setBalance(getBalance()-amount);
        return getBalance();

    }

    @Override
    public double CalculateInterest(double percentage) {
        double interest = getBalance()*(percentage/100)*1;
        setBalance(getBalance()+interest);
        return getBalance();
    }
}

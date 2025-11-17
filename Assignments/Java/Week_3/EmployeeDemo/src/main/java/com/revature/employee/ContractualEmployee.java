package com.revature.employee;

public class ContractualEmployee extends Employee implements PayCalculator {

    public ContractualEmployee() {
    }

    public ContractualEmployee(String name,int timeWorked) {
        super(name, timeWorked);
    }

    @Override
    public void CalculatePay() {
        double pay = getTimeWorked()*PAY_PER_HOUR;
        setAmountPayed(pay);
    }
}

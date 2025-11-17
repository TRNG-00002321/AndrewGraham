package com.revature.employee;

public class SalariedEmployee extends Employee implements PayCalculator {
    private final String[] benefits = {"Dental", "Eye Care", "Stocks"};

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, int timeWorked) {
        super(name, timeWorked);
    }

    @Override
    public void CalculatePay() {
        double pay = getTimeWorked()*PAY_PER_DAY;
        setAmountPayed(pay);
    }

    public String[] getBenefits(){
        return benefits;
    }

    public void viewBenefits(){
        for(String value : benefits)
            System.out.println(value);
    }
}

package com.revature.employee;

public abstract class Employee {
    private String name;
    private int timeWorked;
    private double amountPayed;

    public Employee() {

    }

    public Employee(String name, int timeWorked) {
        this.name = name;
        this.timeWorked = timeWorked;
        this.amountPayed = 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", timeWorked=" + timeWorked +
                ", amountPayed=" + amountPayed +
                '}';
    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

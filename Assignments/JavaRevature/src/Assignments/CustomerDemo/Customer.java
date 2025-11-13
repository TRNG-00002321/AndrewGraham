package Assignments.CustomerDemo;

public class Customer {

    protected String name;
    protected String email;
    protected int purchases;
    protected static int numOfCustomer;
    final String custType = "ADULT";

    Customer(){
        this.name = "anonymous";
        this.email = "anonymous@gmail.com";
        this.purchases =0;
        numOfCustomer++;
    }
    Customer(String name, String email){
        this.name = name;
        this.email = email;
        this.purchases =0;
        numOfCustomer++;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public int getPurchases(){
        return this.purchases;
    }

    public void addPurchase(){
        this.purchases++;
    }
    public void addPurchase(int numPurchases){
        this.purchases += numPurchases;
    }




}

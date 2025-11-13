package Assignments.CustomerDemo;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer("John", "John@gmail.com");

        c1.addPurchase();
        c2.addPurchase(3);
        System.out.println("c2 email: " + c2.getEmail());
        System.out.println("c1 name: " + c1.getName());
        System.out.println("c2 purchases: " + c2.getPurchases());
        System.out.println("Number of customers:" + Customer.numOfCustomer);

    }
}

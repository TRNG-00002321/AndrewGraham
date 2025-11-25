package com.revature.java8.lambdaAssignments;

public class mainClass {

    public static void main(String[] args) {
        //no parameters or return
        //Hello hello = ()->{System.out.println("Hello");};
        //hello.printHello();

        //1 parameter
        //Hello hello = (str) ->{return "Hello " + str.toUpperCase();};
        //System.out.println(hello.printHello("andrew"));

        //2 parameters
        Hello hello = (str1, str2) ->{return "Hello "+ str1 + str2;};

        System.out.println(hello.printHello("Andrew","Graham"));
    }
}

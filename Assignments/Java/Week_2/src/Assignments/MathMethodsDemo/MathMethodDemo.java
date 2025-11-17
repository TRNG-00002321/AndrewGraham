package Assignments.MathMethodsDemo;

public class MathMethodDemo {

    public static int add(int int1, int int2){
        return int1+int2;
    }

    public static int subtract(int int1, int int2){
        return int1-int2;
    }

    public static int multiply(int int1, int int2){
        return int1*int2;
    }

    public static double divide(int int1, int int2){
        if (int2 == 0) {
            System.out.println("Division by zero");
            return -404;
        }
        return (double)int1/int2;
    }
}

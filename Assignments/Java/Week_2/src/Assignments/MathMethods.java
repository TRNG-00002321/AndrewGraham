package Assignments;

public class MathMethods {
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


    public static void main(String ...args) {

        int int1 = Integer.parseInt(args[0]);
        int int2 = Integer.parseInt(args[1]);
        System.out.println(add(int1, int2));
        System.out.println(subtract(int1, int2));
        System.out.println(multiply(int1, int2));
        System.out.println(divide(int1, int2));



    }
}

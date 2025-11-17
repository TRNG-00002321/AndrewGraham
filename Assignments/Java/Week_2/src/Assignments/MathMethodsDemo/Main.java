package Assignments.MathMethodsDemo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int int1 = scanner.nextInt();
        int int2 = scanner.nextInt();
        System.out.println(MathMethodDemo.add(int1,int2));
        System.out.println(MathMethodDemo.subtract(int1,int2));
        System.out.println(MathMethodDemo.multiply(int1,int2));
        System.out.println(MathMethodDemo.divide(int1,int2));
    }
}

package Other;
import java.util.Scanner;
public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println(factorialRec(value));

    }

    public static int factorial(int value){
        int factVal = 1;
        for(int i = value; i>1; i--){
            factVal *= i;
        }
        return factVal;
    }

    public static int factorialRec(int value){
        //int factVal = 1;
        if(value > 1) {

            return value * factorialRec(value-1);
        }
        else{
            return 1;
        }

    }
}

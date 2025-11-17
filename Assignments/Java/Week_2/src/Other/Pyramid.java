package Other;

import java.util.Scanner;
public class Pyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int length = scanner.nextInt();

        for(int i = 1; i <=length; i++){
            for( int j = 1; j <=i; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = length-1; i >0; i--){
            for( int j = i; j >0; j--)
                System.out.print("*");
            System.out.println();
        }

        for(int i = 1; i <=length; i++){
            for( int j = 1; j <=i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}





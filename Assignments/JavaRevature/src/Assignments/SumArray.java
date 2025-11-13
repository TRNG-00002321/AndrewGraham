package Assignments;

public class SumArray {

    public static void main(String[] args) {

        int [][] arr = {
                {14,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        System.out.println("The sum of the matrix is: " + sum2D(arr));

    }

    public static int sum2D(int[][] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for( int j = 0; j < arr[i].length; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
}

package Assignments;

public class MaxMinArray {

    public static void main(String[] args) {
        int [][] arr = {
                {14,25,32,54},
                {25,6,87,48},
                {19,10,51,2}
        };

        System.out.println("The max value in the matric is: " + maxMin2D("max", arr));
        System.out.println("The min value in the matric is: " + maxMin2D("min", arr));

    }



    public static int maxMin2D(String limit,int[][] arr){
        int value = arr[0][0];
        for(int i = 0; i < arr.length; i++){
            for( int j = 0; j < arr[i].length; j++){
                if(limit.equals("max")) {
                    if (arr[i][j] > value) {
                        value = arr[i][j];
                    }
                }
                else {
                    if (arr[i][j] < value) {
                        value = arr[i][j];
                    }
                }
            }

        }

        return value;
    }
}

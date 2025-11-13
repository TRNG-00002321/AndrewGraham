package Assignments;

public class MatrixAddition {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int[][] arr2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {1,2,3,4}
        };
        int[][] matrixSum = matrixAdd(arr1, arr2);
        for(int i = 0; i < matrixSum.length; i++){
            for( int j = 0; j < matrixSum[i].length; j++){
                System.out.print(matrixSum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixAdd(int[][] arr1, int[][] arr2){
        int[][] sumMatrix = new int[arr1.length][arr1[0].length];
        if(arr1[0].length != arr2[0].length)
            if(arr1.length != arr2.length) {
                System.out.println("Invalid dimensions. Returning empty matrix");
                return sumMatrix;
            }
        for(int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                int sum = arr1[i][j] + arr2[i][j];
                sumMatrix[i][j] = sum;
            }
        }

        return sumMatrix;
    }
}

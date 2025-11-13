package Assignments;

public class RowColumnSums {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] rowSums = rowColSum("row",arr);
        System.out.print("Row sums: ");
        for(int i=0; i < rowSums.length; i++) {
            System.out.print(rowSums[i] + " ");
        }
        System.out.println();


        int[] colSums = rowColSum("col",arr);
        System.out.print("Column sums: ");
        for(int i=0; i < colSums.length; i++) {
            System.out.print(colSums[i] + " ");
        }
        System.out.println();

    }

    public static int[] rowColSum(String value, int[][] arr){
        int[] sums = new int[arr.length];
        int sum;
        for(int i = 0; i < arr.length; i++){
            sum = 0;
            for( int j = 0; j < arr[i].length; j++){
                if(value.equals("row"))
                    sum += arr[i][j];
                else
                    sum += arr[j][i];
            }
            sums[i]= sum;
        }
        return sums;
    }


}

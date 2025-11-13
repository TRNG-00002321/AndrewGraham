public class MultTable {

    public static void main(String...args){

        int value = Integer.parseInt(args[0]);
        System.out.println("Multiplication value is " + value);
        int counter = 1;
        int multValue;
        while(counter <= 10){
            multValue = counter*value;
            System.out.println(counter + " * " + value + " = " + multValue);
            counter++;
        }

    }
}

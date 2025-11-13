public class Largest {

    public static void main(String...args){
        int value1 = Integer.parseInt(args[0]);
        int value2 = Integer.parseInt(args[1]);
        int value3 = Integer.parseInt(args[2]);
        //System.out.println(value1 + " " + value2 + " " + value3);
        int largest = value1;
        if(value2>= largest)
            largest = value2;
        if(value3 >= largest)
            largest = value3;
        System.out.println("The largest of the three numbers is " +largest);
    }
}

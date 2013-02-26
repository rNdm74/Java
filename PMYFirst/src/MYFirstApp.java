import java.util.Random;

//package pmyfirst;

public class MYFirstApp {

    private static int number;
    private static int number2;
    
    public static void main(String[] args) {
        System.out.println("my first line");
        System.out.println(Math.PI);
        // Print out 5 more methods from the math class.
        System.out.println(Math.E);
        System.out.println(Math.floor(Math.PI));
        System.out.println(Math.ceil(Math.PI));
        System.out.println(Math.cos(Math.E));
        System.out.println(Math.tan(Math.E));
        
        Random generator = new Random();
        
        int dice = (generator.nextInt(6)+ 1);
        
        System.out.println(dice);
        System.out.println("Number is a static class variable");
        number = 5;
        //declare a local variable called number 2.
        number2 = dice;
    }
}

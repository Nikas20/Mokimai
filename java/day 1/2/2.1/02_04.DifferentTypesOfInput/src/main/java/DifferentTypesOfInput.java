
import java.util.Scanner;

public class DifferentTypesOfInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        System.out.println("Give a string:");
        String string = scan.nextLine();
        System.out.println("You gave the string " + string);

        System.out.println("Give an integer:");
        int inte = Integer.parseInt(scan.nextLine());
        System.out.println("You gave the integer " + inte);

        System.out.println("Give a double:");
        double doble = Double.parseDouble(scan.nextLine());
        System.out.println("You gave the double " + doble);

        System.out.println("Give a boolean:");
        boolean bolen = Boolean.parseBoolean(scan.nextLine());
        System.out.println("You gave the boolean " + bolen);
    }
}

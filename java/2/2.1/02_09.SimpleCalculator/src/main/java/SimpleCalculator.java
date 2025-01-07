
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number: ");
        double firstnumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the second number: ");
        double secondnumber = Integer.parseInt(scanner.nextLine());
        System.out.println(firstnumber + " + " + secondnumber + " = " + (firstnumber + secondnumber));
        System.out.println(firstnumber + " - " + secondnumber + " = " + (firstnumber - secondnumber));
        System.out.println(firstnumber + " * " + secondnumber + " = " + (firstnumber * secondnumber));
        System.out.println(firstnumber + " / " + secondnumber + " = " + (firstnumber / secondnumber));
    }
}

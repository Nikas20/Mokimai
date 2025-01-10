
import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number");
        double firstnumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Give the second number");
        double secondnumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Give the third number");
        double thirdnumber = Double.parseDouble(scanner.nextLine());
        double average = (firstnumber + secondnumber + thirdnumber) / 3;
        System.out.println("The average is " + average);
    }
}

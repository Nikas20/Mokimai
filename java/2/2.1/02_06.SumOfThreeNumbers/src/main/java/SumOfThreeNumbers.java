
import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number");
        int firstnumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the second number");
        int secondnumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the third number");
        int thirdnumber = Integer.parseInt(scanner.nextLine());
        int sum = firstnumber + secondnumber + thirdnumber;
        System.out.println("The sum of the numbers is " + sum);
    }
}

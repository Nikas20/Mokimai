
import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbercaunt = 0;
        int numbersum = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                System.out.println("Number of numbers: " + numbercaunt);
                System.out.println("Sum of the numbers: " + numbersum);
                break;
            } else {
                numbercaunt++;
                numbersum = numbersum + number;
            }
        }
    }
}

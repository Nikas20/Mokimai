
import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbercaunt = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                System.out.println("Sum of the numbers: " + numbercaunt);
                break;
            } else {
                numbercaunt = numbercaunt + number;
            }
        }
    }
}

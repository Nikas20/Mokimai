
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you can write test code here
        // however, remove all unnecessary code when doing the final parts of the exercise
        Statistics statistics = new Statistics();
        // In order for the tests to work, the objects must be created in the
        // correct order in the main program. First the object that tracks the total
        // sum, secondly the object that tracks the sum of even numbers, 
        // and lastly the one that tracks the sum of odd numbers!
        int evensum = 0;
        System.out.println("Enter numbers:");
        System.out.println(statistics.average());
        while (true) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == -1) {
                break;
            } else {
                statistics.addNumber(number);
                if (number % 2 == 0) {
                    evensum = evensum + number;
                }
            }
        }
        int odd = statistics.sum() - evensum;
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.sum());
        System.out.println("Sum of even numbers: " + evensum);
        System.out.println("Sum of odd numbers: " + odd);
        System.out.println("Average: " + statistics.average());
    }
}


import java.util.Scanner;

public class FromWhereToWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.printf("Where to? ");
        int number1 = Integer.parseInt(scanner.nextLine());
        System.out.printf("Where from? ");
        int number2 = Integer.parseInt(scanner.nextLine());
        for (int i = number2; i <= number1; i++) {
            System.out.println(i);
        }
    }
}

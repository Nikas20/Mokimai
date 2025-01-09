
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("First number? ");
        int firstnumber = Integer.parseInt(scanner.nextLine());
        System.out.printf("Last number? ");
        int lastnumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = firstnumber; i <= lastnumber; i++) {
            sum = sum + i;
        }
        System.out.println("The sum is " + sum);
    }
}


import java.util.ArrayList;
import java.util.Scanner;

public class OnlyTheseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break;
            }

            numbers.add(number);
        }
        System.out.printf("From where? ");
        int firstnumber = Integer.valueOf(scanner.nextLine());
        System.out.printf("To where? ");
        int secondnumber = Integer.valueOf(scanner.nextLine());
        for (int i = firstnumber; i <= secondnumber; i++) {
            System.out.println(numbers.get(i));
        }
    }
}

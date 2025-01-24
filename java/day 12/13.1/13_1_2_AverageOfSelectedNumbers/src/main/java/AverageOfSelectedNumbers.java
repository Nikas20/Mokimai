import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Implement your program here
        System.out.println("Input numbers, type 'end' to stop");
        List<String> numbers = new ArrayList<>(List.of());
        String num = "";

        while (true) {
            num = scanner.nextLine();
            if (num.equals("end")) {
                break;
            }
            numbers.add(num);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers?(n/p");
        num = scanner.nextLine();

        if (num.equals("p")) {
            OptionalDouble avg = numbers.stream()
                    .mapToDouble(Double::parseDouble)
                    .filter((number) -> number > 0)
                    .average();
            System.out.println(avg);
        } else if (num.equals("n")) {
            OptionalDouble avg = numbers.stream()
                    .mapToDouble(Double::parseDouble)
                    .filter((number) -> number < 0)
                    .average();
            System.out.println(avg);
        }
    }

}


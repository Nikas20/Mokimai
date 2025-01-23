import java.util.*;
import java.util.stream.Stream;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
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

        OptionalDouble avg = numbers.stream().mapToDouble(Double::parseDouble).average();

        System.out.println(avg);
    }
}
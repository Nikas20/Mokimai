import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareEachNumber {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        numbers.replaceAll((number) -> number * number);
        System.out.println(numbers);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAList {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3));
        numbers.sort((number1, number2) -> number2.compareTo(number1));
        System.out.println(numbers);
    }
}

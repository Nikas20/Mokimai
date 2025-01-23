import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAndRemoveEvenNumber {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        numbers.removeIf((nuber -> nuber % 2 == 0));

        System.out.println(numbers);
    }
}

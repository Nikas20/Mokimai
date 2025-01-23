import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountSpecificItems {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "apple", "banana", "apple");
        AtomicInteger counter = new AtomicInteger(0);
        fruits.forEach((fruit) -> {
            if (fruit.equals("apple")) {
                counter.addAndGet(1);
            }
        });
        System.out.println("The word 'apple' " + counter + " times.");

    }
}

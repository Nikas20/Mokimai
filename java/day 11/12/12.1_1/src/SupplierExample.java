import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {


        Supplier<String> randomGreeting = () -> {

            String arr[] = {"Hi", "Helo", "Hai", "Sveiki"};

            int rnd = new Random().nextInt(arr.length);

            return arr[rnd];
        };

        System.out.println(randomGreeting.get());
    }
}

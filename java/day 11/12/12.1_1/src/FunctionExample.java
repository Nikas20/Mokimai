import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> intToString = num -> "Value: " + num.toString();

        System.out.println(intToString.apply(5));

    }
}
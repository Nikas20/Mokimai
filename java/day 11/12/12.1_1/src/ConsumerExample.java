import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<String> printMessage = (word) -> System.out.println(word + " is awesome!");

        printMessage.accept("Java");

    }
}

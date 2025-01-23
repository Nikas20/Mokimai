import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveStringsContainingSpecificCharacters {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "fig"));
        words.removeIf((word) -> word.contains("e"));
        System.out.println(words);
    }
}

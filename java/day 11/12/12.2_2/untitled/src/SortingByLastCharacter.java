import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingByLastCharacter {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Eve", "Alice", "Charlie", "Bob"));

        Collections.sort(names, (name1, name2) -> name1.charAt(name1.length() - 1) - name2.charAt(name2.length() - 1));
        System.out.println(names);
    }
}

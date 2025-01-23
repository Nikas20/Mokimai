import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNamesBasedOnLength {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList("Tom", "Lisa", "Eve", "Robert", "Kate"));

        names.removeIf((name) -> name.length() < 4);
        System.out.println(names);
    }
}

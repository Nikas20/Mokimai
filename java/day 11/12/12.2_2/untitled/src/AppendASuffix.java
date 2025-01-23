import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendASuffix {

    public static void main(String[] args) {

        List<String> tasks = new ArrayList<>(Arrays.asList("task1", "task2", "task3"));
        tasks.replaceAll((task) -> task + "_done");
        System.out.println(tasks);

    }
}

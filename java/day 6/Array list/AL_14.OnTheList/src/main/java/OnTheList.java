
import java.util.ArrayList;
import java.util.Scanner;

public class OnTheList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            list.add(input);
        }
        System.out.printf("Search for? ");
        String name = scanner.nextLine();
        boolean areTrue = false;
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i))) {
                areTrue = true;
            }
        }
        if (areTrue == true) {
            System.out.println(name + " was found!");
        } else {
            System.out.println(name + " was not found!");
        }
    }
}

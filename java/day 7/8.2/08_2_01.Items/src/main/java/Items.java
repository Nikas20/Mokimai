
import java.util.ArrayList;
import java.util.Scanner;

public class Items {

    public static void main(String[] args) {
        // implement here your program that uses the class Item

        ArrayList<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Name: ");
            String elemnt = scanner.nextLine();
            if (elemnt.equals("")) {
                break;
            } else {
                Item item = new Item(elemnt);
                items.add(item);
            }
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }

    }
}

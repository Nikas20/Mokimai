import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class

        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // implement here the program that allows the user to enter 
        // book information and to examine them
        while (true) {
            System.out.printf("Name: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.printf("Pages: ");
            int pages = Integer.parseInt(scanner.nextLine());
            System.out.printf("Publication year: ");
            int year = Integer.parseInt(scanner.nextLine());
            Book inf = new Book(name, pages, year);
            books.add(inf);

        }
        System.out.println();
        System.out.printf("What information will be printed? ");
        String tipe = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (tipe.equals("everything")) {
                System.out.println(books.get(i).toString());
            } else if (tipe.equals("name")) {
                System.out.println(books.get(i).getName());
            }
        }
    }
}


import java.util.Scanner;

public class Same {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here.
        System.out.println("Enter the first string:");
        String firststring = scan.nextLine();

        System.out.println("Enter the second string:");
        String secondstring = scan.nextLine();

        if (firststring.equals(secondstring)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
    }
}

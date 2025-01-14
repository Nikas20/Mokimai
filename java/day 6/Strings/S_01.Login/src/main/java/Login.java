
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = "alex";
        String pass1 = "sunshine";
        String name2 = "emma";
        String pass2 = "haskell";
        System.out.printf("Enter username ");
        String name = scanner.nextLine();
        System.out.printf("Enter password ");
        String pass = scanner.nextLine();
        if ((name.equals(name1) && pass.equals(pass1)) || (name.equals(name2) && pass.equals(pass2))) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }
    }

}

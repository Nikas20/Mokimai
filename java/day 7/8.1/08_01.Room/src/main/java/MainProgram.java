
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String classCode = scanner.nextLine();
        int numberOfSeats = Integer.parseInt(scanner.nextLine());
        Room room1 = new Room(classCode, numberOfSeats);
        // Follow the instructions carefully 
        // and run the tests.
    }

}

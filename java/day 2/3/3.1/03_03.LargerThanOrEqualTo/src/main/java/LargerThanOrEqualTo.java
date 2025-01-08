
import java.util.Scanner;

public class LargerThanOrEqualTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give the first number:");
        int firstnuber = Integer.parseInt(scan.nextLine());
        System.out.println("Give the second number:");
        int secondnuber = Integer.parseInt(scan.nextLine());
        if (firstnuber > secondnuber) {
            System.out.println("Greater number is: " + firstnuber);
        } else if (secondnuber > firstnuber) {
            System.out.println("Greater number is: " + secondnuber);
        } else {
            System.out.println("The numbers are equal!");
        }
    }
}

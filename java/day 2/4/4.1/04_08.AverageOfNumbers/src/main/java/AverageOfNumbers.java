
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numbercaunt = 0;
        double numbersum = 0;
        double numberaverage = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                System.out.println("Average of the numbers: " + numberaverage);
                break;
            } else {
                numbercaunt++;
                numbersum = numbersum + number;
                numberaverage = numbersum / numbercaunt;
            }
        }
    }
}

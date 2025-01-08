
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {

        // This exercise is worth five exercise points, and it is 
        // gradually extended part by part.

        // If you want, you can send this exercise to the server
        // when it's just partially done. In that case the server will complain about 
        // the parts you haven't done, but you'll get points for the finished parts.

        Scanner scanner = new Scanner(System.in);
        int numbercaunt = 0;
        int numbersum = 0;
        int odd = 0;
        int even = 0;
        double numberaverage = 0;
        System.out.println("Give a number:");
        while (true) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == -1) {
                System.out.println("Thx! Bye!");
                System.out.println("Sum: " + numbersum);
                System.out.println("Numbers: " + numbercaunt);
                System.out.println("Average: " + numberaverage);
                System.out.println("Even: " + even);
                System.out.println("Odd: " + odd);
                break;
            } else {
                numbercaunt++;
                numbersum = numbersum + number;
                numberaverage = (double) numbersum / numbercaunt;
                if ((number % 2) > 0 || (number % 2) < 0) {
                    odd++;
                } else {
                    even++;
                }
            }
        }
    }
}

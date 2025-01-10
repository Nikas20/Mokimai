import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter miles:");
        int miles = Integer.parseInt(scanner.nextLine());
        float km = (float) (miles * 1.6);
        System.out.println(miles + " miles is " + km + " kilometers");
    }
}
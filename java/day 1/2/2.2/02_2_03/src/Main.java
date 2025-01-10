import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x1:");
        double x1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter y1:");
        double y1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter x2:");
        double x2 = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter y2:");
        double y2 = Double.parseDouble(scanner.nextLine());

        double position = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        System.out.println("The distance between the two points is " + position);
    }
}
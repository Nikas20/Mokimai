import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of minutes:");
        int minut = Integer.parseInt(scanner.nextLine());
        int day = minut / 1440;
        int year = day / 365;
        day = day - year * 365;
        System.out.println(minut + " minutes is approximately " + year + " years and " + day + " days");
    }
}
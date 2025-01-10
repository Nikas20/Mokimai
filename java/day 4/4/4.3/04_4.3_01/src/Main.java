import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= 4; i++) {
            System.out.println("Weak " + i);
            for (int j = 1; j <= 7; j++) {
                System.out.printf("      ");
                System.out.println("Day " + j);
            }
        }
    }
}
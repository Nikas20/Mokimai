public class Main {
    public static void main(String[] args) {
        int n = 8;
        String sivol = "#";
        String empt = " ";
        for (int i = 1; i <= n; i++) {
            System.out.printf(sivol + " ");
            for (int j = 2; j <= n; j++) {
                if (i == 1 || i == 8) {
                    System.out.printf(sivol + " ");
                } else {
                    System.out.printf(" " + " ");
                }
            }
            System.out.printf(sivol + " ");
            System.out.println();
        }
    }
}
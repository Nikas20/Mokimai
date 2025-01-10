public class Main {
    public static void main(String[] args) {
        numberPattern(4);
    }

    public static void numberPattern(int rows) {
        String number = "";
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                number = String.valueOf(j);
                System.out.printf(number);
            }
            System.out.println();
        }
    }
}
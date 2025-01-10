public class Main {
    public static void main(String[] args) {
        oddMultiplicationTable(5);
    }

    public static void oddMultiplicationTable(int number) {
        String number3 = "";
        int answer = 1;
        for (int i = 1; i <= 5; i += 2) {
            for (int j = 1; j <= 5; j += 2) {
                answer = i * j;

                if (answer < 10) {
                    number3 = " " + String.valueOf(answer);
                } else {
                    number3 = String.valueOf(answer);
                }
                System.out.printf(number3 + " ");
            }
            System.out.println();
        }
    }
}
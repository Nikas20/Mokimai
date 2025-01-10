public class Main {
    public static void main(String[] args) {
        String number = "";
        String number2 = "";
        int answer = 1;
        for (int i = 1; i <= 9; i++) {
            number = String.valueOf(i);
            System.out.printf(number + " | ");
            for (int j = 1; j <= 9; j++) {
                answer = i * j;

                if (answer < 10) {
                    number2 = " " + String.valueOf(answer);
                } else {
                    number2 = String.valueOf(answer);
                }
                System.out.printf(number2 + " ");
            }
            System.out.println();
        }
    }
}
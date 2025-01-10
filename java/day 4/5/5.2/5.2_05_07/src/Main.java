public class Main {
    public static void main(String[] args) {
        System.out.println(countDivisors(12));
    }

    public static int countDivisors(int number) {

        int limit = (int) Math.sqrt(number);
        int count = 2;
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                count++;
                if (number / i != i) {
                    count++;
                }
            }
        }
        return count;
    }
}
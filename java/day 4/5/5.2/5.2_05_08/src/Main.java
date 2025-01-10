public class Main {
    public static void main(String[] args) {
        System.out.println(isPerfect(6));
        System.out.println(isPerfect(15));
    }

    public static boolean isPerfect(int number) {
        int limit = (int) Math.sqrt(number);
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            if (number % i == 0) {
                sum += i;
                if (number / i != i) {
                    sum += i;
                }
            }
        }
        if (sum == number) {
            return true;
        } else {
            return false;
        }

    }

}
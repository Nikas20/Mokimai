public class Main {
    public static void main(String[] args) {
        System.out.println(calculatePower(2, 3));
    }

    public static int calculatePower(int base, int exponent) {
        int mult = base;
        for (int i = 2; i <= exponent; i++) {
            base = base * mult;
        }
        return base;
    }
}
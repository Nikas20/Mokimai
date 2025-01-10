public class Main {
    public static void main(String[] args) {
        System.out.println(digitSum(123));
    }

    public static int digitSum(int number) {
        int hunder = number / 100;
        int ten = (number - hunder * 100) / 10;
        int unit = number - hunder * 100 - ten * 10;
        return hunder + ten + unit;
    }
}
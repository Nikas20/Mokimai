public class Main {
    public static void main(String[] args) {
        System.out.println(convertTemp(25));
    }

    public static String convertTemp(double celsius) {
        double fahreinheit = celsius * 1.8 + 32;
        return String.valueOf(celsius) + "°C is equal to " + fahreinheit + "°F";
    }
}
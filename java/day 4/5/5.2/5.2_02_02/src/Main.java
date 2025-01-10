public class Main {
    public static void main(String[] args) {
        System.out.println(minutesToTime(185));
    }

    public static String minutesToTime(int minutes) {
        int hour = minutes / 60;
        minutes = minutes - hour * 60;
        return hour + " hours and " + minutes + " minutes";
    }
}
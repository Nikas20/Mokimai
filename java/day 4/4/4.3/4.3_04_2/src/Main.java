public class Main {
    public static void main(String[] args) {
        String hours = "";
        String minuts = "";
        for (int i = 01; i <= 24; i++) {
            for (int j = 01; j <= 60; j++) {
                if (i < 10) {
                    hours = "0" + i;
                } else {
                    hours = String.valueOf(i);
                }
                if (j < 10) {
                    minuts = "0" + j;
                } else {
                    minuts = String.valueOf(j);
                }
                System.out.println(hours + " : " + minuts);
            }
        }
    }
}
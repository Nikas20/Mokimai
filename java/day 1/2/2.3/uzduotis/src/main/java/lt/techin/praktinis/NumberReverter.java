package lt.techin.praktinis;

public class NumberReverter {
    public void revert(int number) {
        // Write your program here
        int hunder = number / 100;
        int venetas = number % 10;
        int result = venetas * 100 + hunder + (number - (hunder * 100 + venetas));
        System.out.println(result);

    }
}

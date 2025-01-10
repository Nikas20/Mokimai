package lt.techin.praktinis;

public class DigitsSumCalculator {
    public void calculateSum(int number) {
        // Write your program here
        int result = 0;
        int tausan = number / 1000;
        int hunder = (number - tausan * 1000) / 100;
        int ten = (number - tausan * 1000 - hunder * 100) / 10;
        int ventas = number - tausan * 1000 - hunder * 100 - ten * 10;
        result = tausan + hunder + ten + ventas;

        System.out.println(result);

    }
}

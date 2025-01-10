package lt.techin.praktinis;

public class CupsCalculator {

    public void calculateCups(int numberOfCups) {
        int dez = numberOfCups / 3;
        int likopod = numberOfCups - dez * 3;
        System.out.println("Dėžių: " + dez);
        System.out.println("Liko puodelių: " + likopod);
    }

}

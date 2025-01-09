
public class AdvancedAstrology {

    public static void printStars(int number) {
        // part 1 of the exercise
        String star = "*";
        for (int i = 1; i <= number; i++) {
            System.out.printf(star);
        }
    }

    public static void printSpaces(int number) {
        // part 1 of the exercise
        String space = " ";
        for (int i = 1; i <= number; i++) {
            System.out.printf(space);
        }
    }

    public static void printTriangle(int size) {
        // part 2 of the exercise
        int empt = size;

        for (int i = 1; i <= size; i++) {
            empt = empt - 1;
            printSpaces(empt);
            printStars(i);
            System.out.println("");
        }

    }

    public static void christmasTree(int height) {
        // part 3 of the exercise
    }

    public static void main(String[] args) {
        // The tests are not checking the main, so you can modify it freely.

        printTriangle(5);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}

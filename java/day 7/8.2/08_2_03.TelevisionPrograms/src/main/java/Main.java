import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class

        ArrayList<TelevisionProgram> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Name: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.printf("Duration: ");
            int duration = Integer.parseInt(scanner.nextLine());
            TelevisionProgram inf = new TelevisionProgram(name, duration);
            programs.add(inf);

        }
        System.out.println();
        System.out.printf("Program's maximum duration? ");
        int time = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getDuration() <= time) {
                System.out.println(programs.get(i).toString());
            }
        }
    }
}

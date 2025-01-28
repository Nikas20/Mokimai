package lt.techin;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(" Yes or no?");
      String answer = scanner.nextLine();
      if (answer.equals("no")) {
        break;
      } else if (answer.equals("Yes")) {
        continue;
      }
    }
  }
}


import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("First name: ");
            String firstname = scanner.nextLine();
            if (firstname.equals("")) {
                break;
            }
            System.out.printf("Last name: ");
            String lastName = scanner.nextLine();
            System.out.printf("Indentification number: ");
            String identificationNumber = scanner.nextLine();
            PersonalInformation inf = new PersonalInformation(firstname, lastName, identificationNumber);
            infoCollection.add(inf);

        }
        System.out.println();
        for (int i = 0; i < infoCollection.size(); i++) {
            System.out.println(infoCollection.get(i).getFirstName() + " " + infoCollection.get(i).getLastName());
        }
    }
}

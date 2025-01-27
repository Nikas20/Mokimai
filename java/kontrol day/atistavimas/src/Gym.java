import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

public class Gym {
    ArrayList<String> membershiplist = new ArrayList<>();
    ArrayList<String> listOfMembers = new ArrayList<>();
    HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

    public Gym() {
    }

    public void addMember(int id, String name, int age) {
        listOfMembers.add(String.valueOf(new Member(id, name, age)));
        map.put(id, new ArrayList<>());
        map.get(id).add(name);
        map.get(id).add(String.valueOf(age));
    }

    //Member member = map;
    public void printMembers() {
        System.out.println("Members:");
        for (int i = 0; i < listOfMembers.size(); i++) {
            System.out.println(listOfMembers.get(i));
        }
    }

    public void assignMembership(MonthlyMembership monthlyMembership) {
        membershiplist.add(monthlyMembership.toString());
    }

    public void assignMembership(AnnualMembership annualMembership) {
        membershiplist.add(annualMembership.toString());
    }

    public void printMemberships() {
        System.out.println("Memberships:");
        for (int i = 0; i < membershiplist.size(); i++) {
            System.out.println(membershiplist.get(i));
        }
    }

    public void addGymClass(String className, String schedule) {
        new GymClass(className, schedule);
    }

    public void enrollMemberInClass(int id, String className) {

    }

    public void printClassEnrollments() {
        System.out.println("Class Enrollments:");
        System.out.println();
    }
}

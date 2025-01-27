import java.util.ArrayList;
import java.util.Arrays;

public class GymClass {
    private String className;
    private String schedule;
    private ArrayList<String> enrolledMembers = new ArrayList<String>();

    public GymClass(String className, String schedule) {
        this.className = className;
        this.schedule = schedule;
    }

    public void enroll(Member member) {
        String name = member.getName();
        enrolledMembers.add(name);
    }

    @Override
    public String toString() {
        return className +
                "(" + schedule + ") : "
                + enrolledMembers
                .toString()
                .replaceAll("^\\[|\\]$", "");
    }
}

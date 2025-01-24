public class Student extends Person {
    private int credit = 0;

    public Student(String name, String adress) {
        super(name, adress);


    }

    public int credits() {
        return credit;
    }

    public void study() {
        credit += 1;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Study credits " + credit;
    }
}

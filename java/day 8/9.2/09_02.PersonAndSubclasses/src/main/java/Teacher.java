public class Teacher extends Person {
    private int paoment;

    public Teacher(String name, String adress, int paoment) {
        super(name, adress);
        this.paoment = paoment;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  salary " + paoment + " euro/month";
    }
}

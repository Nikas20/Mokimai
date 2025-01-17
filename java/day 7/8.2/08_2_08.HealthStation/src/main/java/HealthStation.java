
public class HealthStation {
    private int count;

    public int weigh(Person person) {
        // return the weight of the person passed as the parameter
        this.count++;
        return person.getWeight();
    }

    public void feed(Person person) {
        int fed = person.getWeight();
        fed += 1;
        person.setWeight(fed);
    }

    public int weighings() {
        return this.count;
    }

}

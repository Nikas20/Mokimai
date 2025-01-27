public class Member {
    private int id;
    private String name;
    private int age;

    public Member(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return id + ": "
                + name
                + ", Age: "
                + age;
    }
}

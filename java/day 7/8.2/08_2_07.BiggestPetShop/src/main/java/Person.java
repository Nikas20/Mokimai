
public class Person {

    private String name;
    private Pet pet;

    public Person(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    public Person(String name) {
        this(name, new Pet("Toothless", "dragon"));
    }// sis kodas jau buvo

    public Person() {
        this("Lilo", new Pet("Stitch", "blue alien"));
    }// sis kodas jau buvo

    @Override
    public String toString() {
        return this.name + ", has a friend called " + this.pet.getName() + (this.pet.getBreed());
    }

}

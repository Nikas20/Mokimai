public class CD implements Packable {
    String artist;
    String name;
    int publicationyear;

    public CD(String artist, String name, int publicationyear) {
        this.artist = artist;
        this.name = name;
        this.publicationyear = publicationyear;
    }

    @Override
    public String toString() {
        return artist + ": " + name + " (" + publicationyear + ")";
    }

    @Override
    public double weight() {
        return 0.1;
    }
}

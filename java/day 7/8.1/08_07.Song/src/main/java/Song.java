public class Song {
    private String name;
    private int length;

    public Song(String name, int lenght) {
        this.name = name;
        this.length = lenght;
    }

    public String name() {
        return this.name;
    }

    public int length() {
        return this.length;
    }
}

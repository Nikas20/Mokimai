import java.util.ArrayList;

public class Box implements Packable {
    private double maxweight;
    private ArrayList<Packable> items;

    public Box(double maxweight) {
        this.maxweight = maxweight;
        items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (maxweight >= item.weight()) {
            items.add(item);
            maxweight = maxweight - item.weight();
        }
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            weight = weight + item.weight();
        }
        return weight;
    }
}

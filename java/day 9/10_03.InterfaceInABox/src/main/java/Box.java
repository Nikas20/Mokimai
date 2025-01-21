import java.util.ArrayList;

public class Box implements Packable {
    private double maxweight;
    private ArrayList<Packable> items;


    public Box(double maxweight) {
        this.maxweight = maxweight;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (maxweight > items.get(items.indexOf(item)).weight()) {
            items.add(item);
            maxweight = maxweight - items.get(items.indexOf(item)).weight();
        }

    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }

    @Override
    public double weight() {
        double weight = 0;
        for (int i = 0; i < items.size(); i++) {
            weight = weight + items.get(i).weight();
        }
        return weight;
    }
}

import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private ArrayList<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (capacity > item.getWeight()) {
            capacity = capacity - item.getWeight();
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}


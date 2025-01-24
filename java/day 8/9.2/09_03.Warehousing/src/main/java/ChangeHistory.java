import java.util.ArrayList;
import java.util.Comparator;
import java.util.OptionalDouble;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        history.clear();
    }

    public double average() {
        double avg = history.stream()
                .mapToDouble(x -> x)
                .average()
                .orElse(0);
        return avg;
    }

    public double maxValue() {
        double max = history.stream()
                .max(Comparator.naturalOrder())
                .orElse(Double.valueOf(0));
        return max;
    }

    public double minValue() {
        return history.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    @Override
    public String toString() {
        return String.valueOf(history);
    }
}


public class Statistics {
    private int count;
    private int sum;

    public Statistics() {

    }

    public void addNumber(int number) {
        this.count = this.count + 1;
        this.sum = this.sum + number;
    }


    public int getCount() {
        return this.count;
    }

    public int sum() {
        return this.sum;
    }

    public double average() {
        double average = 0;
        if (count == 0) {
            return 0;
        } else {
            return average = (double) this.sum / this.count;
        }

    }
}

public class Debt {
    private double balance;
    private double interstRate;

    public Debt(double initialBalance, double initialinterstRate) {
        this.balance = initialBalance;
        this.interstRate = initialinterstRate;
    }

    public void printBalance() {
        System.out.println(this.balance);
    }

    public void waitOneYear() {
        this.balance = this.balance * this.interstRate;
    }
}

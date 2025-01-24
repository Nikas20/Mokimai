import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;
    private Date dateCreated;

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void change(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public void changeData(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate() {
        return this.annuallnterestRate;
    }

    public double getMonthlyInterest() {
        return this.annuallnterestRate * balance;
    }

    public void withdraw(double withdraw) {
        this.balance = this.balance - withdraw;
    }

    public void deposit(double deposite) {
        this.balance = this.balance + deposite;
    }
}

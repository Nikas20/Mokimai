public class PaymentCard {
    private double balance;

    public PaymentCard(double openingBalance) {
        this.balance = openingBalance;
    }

    public String toString() {
        return "The card has a balance of " + this.balance + " euros";
    }

    public void eatAffordably() {
        if (this.balance >= 2.6) {
            this.balance = this.balance - 2.6;
        }
    }

    public void eatHeartily() {
        if (this.balance >= 4.6) {
            this.balance = this.balance - 4.6;
        }
    }

    public void addMoney(double amout) {
        if (amout > 0) {
            if (this.balance + amout <= 150) {
                this.balance = this.balance + amout;
            } else {
                this.balance = 150;
            }
        }
    }
}

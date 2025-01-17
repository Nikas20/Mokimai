
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        Money newMoney = new Money(this.euros + addition.euros, this.cents + addition.cents);
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        if (this.euros * 100 + this.cents < compared.euros * 100 + compared.cents) {
            return true;
        } else {
            return false;
        }
    }

    public Money minus(Money addition) {
        int newEuros = 0;
        int newCents = 0;
        if (this.euros - addition.euros >= 0) {
            newEuros = this.euros - addition.euros;


            if (this.cents < addition.cents && this.euros - addition.euros > 0) {
                newEuros = newEuros - 1;
                newCents = (this.cents + 100) - addition.cents;
            } else {
                newCents = this.cents - addition.cents;
            }
        }
        Money newMoney = new Money(newEuros, newCents);
        return newMoney;
    }
}

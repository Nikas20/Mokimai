import java.time.Duration;

public class MonthlyMembership extends Membership {
    private int duration;

    public MonthlyMembership(int membershipId, int memberId, int duration) {
        super(membershipId, memberId);
        this.duration = duration;
    }

    @Override
    int getCost() {
        return duration * 30;
    }

    @Override
    public String toString() {
        return "MonthlyMembership, Cost: " + getCost() + ".0, Duration: " + duration + " months";
    }
}

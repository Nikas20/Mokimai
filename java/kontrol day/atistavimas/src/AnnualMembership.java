public class AnnualMembership extends Membership {

    public AnnualMembership(int membershipId, int memberId) {
        super(membershipId, memberId);
    }

    @Override
    int getCost() {
        return 300;
    }

    @Override
    public String toString() {
        return "AnnualMembership, Cost: " + getCost() + ".0, Duration 12 months";
    }
}

package insurance.claim;

public class Payout {
    private Claim claim;
    private double amount;

    public Payout(Claim claim, double amount) {
        this.claim = claim;
        this.amount = amount;
        claim.setStatus("Paid");
    }

    @Override
    public String toString() {
        return "Payout [ClaimID=" + claim.getClaimId() + ", Amount=" + amount + ", Status=" + claim.getStatus() + "]";
    }
}

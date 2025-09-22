package insurance.claim;

public class ClaimDecision {
    private Claim claim;
    private boolean approved;
    private String reason;

    public ClaimDecision(Claim claim, boolean approved, String reason) {
        this.claim = claim;
        this.approved = approved;
        this.reason = reason;

        if (approved) {
            claim.setStatus("Approved");
        } else {
            claim.setStatus("Rejected");
        }
    }

    public Claim getClaim() {
        return claim;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "ClaimDecision [ClaimID=" + claim.getClaimId() + ", Approved=" + approved + ", Reason=" + reason + "]";
    }
}

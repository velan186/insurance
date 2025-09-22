package insurance.claim;

public class ClaimAssessment {
    private Claim claim;
    private String notes;

    public ClaimAssessment(Claim claim, String notes) {
        this.claim = claim;
        this.notes = notes;
        claim.setStatus("Assessed");
    }

    public Claim getClaim() {
        return claim;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "ClaimAssessment [ClaimID=" + claim.getClaimId() + ", Notes=" + notes + "]";
    }
}

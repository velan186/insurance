package insurance.claim;

import insurance.policy.Policy;

public class Claim {
    private int claimId;
    private Policy policy;
    private String status; // Filed, Assessed, Approved, Rejected, Paid

    public Claim(int claimId, Policy policy) {
        this.claimId = claimId;
        this.policy = policy;
        this.status = "Filed";
    }

    public int getClaimId() {
        return claimId;
    }

    public Policy getPolicy() {
        return policy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Claim [ClaimID=" + claimId + ", PolicyID=" + policy.getPolicyId() + ", Status=" + status + "]";
    }
}

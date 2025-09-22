package insurance.premium;

import insurance.policy.Policy;

public class PremiumPayment {
    private Policy policy;
    private double amount;
    private boolean paid;

    public PremiumPayment(Policy policy, double amount) {
        this.policy = policy;
        this.amount = amount;
        this.paid = true; // assume recorded successfully
    }

    public Policy getPolicy() {
        return policy;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "PremiumPayment [PolicyID=" + policy.getPolicyId() + ", Amount=" + amount + ", Paid=" + paid + "]";
    }
}

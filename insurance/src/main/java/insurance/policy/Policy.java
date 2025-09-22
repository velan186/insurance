package insurance.policy;

import insurance.customer.Customer;

public class Policy {
    private int policyId;
    private Customer customer;
    private boolean active;

    public Policy(int policyId, Customer customer) {
        this.policyId = policyId;
        this.customer = customer;
        this.active = true; // by default active
    }

    public int getPolicyId() {
        return policyId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "Policy [PolicyID=" + policyId + ", Customer=" + customer.getName() + ", Active=" + active + "]";
    }
}

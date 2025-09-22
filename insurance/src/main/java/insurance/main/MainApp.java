package insurance.main;

import insurance.customer.Customer;
import insurance.policy.Policy;
import insurance.premium.PremiumPayment;
import insurance.claim.*;

import java.util.*;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    private static List<Customer> customers = new ArrayList<>();
    private static List<Policy> policies = new ArrayList<>();
    private static List<PremiumPayment> premiums = new ArrayList<>();
    private static List<Claim> claims = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Insurance Management System ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Policy");
            System.out.println("3. Record Premium");
            System.out.println("4. File Claim");
            System.out.println("5. Assess Claim");
            System.out.println("6. Decide Claim");
            System.out.println("7. Process Payout");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> createPolicy();
                case 3 -> recordPremium();
                case 4 -> fileClaim();
                case 5 -> assessClaim();
                case 6 -> decideClaim();
                case 7 -> processPayout();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        Customer c = new Customer(id, name, contact);
        customers.add(c);
        System.out.println("Added: " + c);
    }

    private static void createPolicy() {
        System.out.print("Enter Policy ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();

        Customer c = customers.stream().filter(x -> x.getId() == cid).findFirst().orElse(null);
        if (c != null) {
            Policy p = new Policy(pid, c);
            policies.add(p);
            System.out.println("Created: " + p);
        } else {
            System.out.println("Customer not found!");
        }
    }

    private static void recordPremium() {
        System.out.print("Enter Policy ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        Policy p = policies.stream().filter(x -> x.getPolicyId() == pid).findFirst().orElse(null);
        if (p != null) {
            PremiumPayment pay = new PremiumPayment(p, amt);
            premiums.add(pay);
            System.out.println("Recorded: " + pay);
        } else {
            System.out.println("Policy not found!");
        }
    }

    private static void fileClaim() {
        System.out.print("Enter Claim ID: ");
        int cid = sc.nextInt();
        System.out.print("Enter Policy ID: ");
        int pid = sc.nextInt();

        Policy p = policies.stream().filter(x -> x.getPolicyId() == pid).findFirst().orElse(null);
        if (p != null && p.isActive()) {
            Claim cl = new Claim(cid, p);
            claims.add(cl);
            System.out.println("Filed: " + cl);
        } else {
            System.out.println("Invalid Policy or Inactive!");
        }
    }

    private static void assessClaim() {
        System.out.print("Enter Claim ID: ");
        int cid = sc.nextInt();
        sc.nextLine();
        Claim cl = claims.stream().filter(x -> x.getClaimId() == cid).findFirst().orElse(null);

        if (cl != null) {
            System.out.print("Enter Assessment Notes: ");
            String notes = sc.nextLine();
            ClaimAssessment ca = new ClaimAssessment(cl, notes);
            System.out.println("Assessed: " + ca);
        } else {
            System.out.println("Claim not found!");
        }
    }

    private static void decideClaim() {
        System.out.print("Enter Claim ID: ");
        int cid = sc.nextInt();
        sc.nextLine();
        Claim cl = claims.stream().filter(x -> x.getClaimId() == cid).findFirst().orElse(null);

        if (cl != null) {
            System.out.print("Approve? (yes/no): ");
            String ans = sc.nextLine();
            boolean approve = ans.equalsIgnoreCase("yes");
            String reason = approve ? "Valid claim" : "Not eligible";
            ClaimDecision cd = new ClaimDecision(cl, approve, reason);
            System.out.println("Decision: " + cd);
        } else {
            System.out.println("Claim not found!");
        }
    }

    private static void processPayout() {
        System.out.print("Enter Claim ID: ");
        int cid = sc.nextInt();
        System.out.print("Enter Payout Amount: ");
        double amt = sc.nextDouble();

        Claim cl = claims.stream().filter(x -> x.getClaimId() == cid).findFirst().orElse(null);
        if (cl != null && "Approved".equals(cl.getStatus())) {
            Payout p = new Payout(cl, amt);
            System.out.println("Payout Done: " + p);
        } else {
            System.out.println("Claim not approved!");
        }
    }
}

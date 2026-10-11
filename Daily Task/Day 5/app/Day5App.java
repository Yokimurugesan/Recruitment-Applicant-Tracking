
package app;

import model.Candidate;
import model.Recruiter;
import model.UserRole;
import payment.Payment;
import payment.CardPayment;
import payment.UPIPayment;
import payment.CashPayment;
import payment.Refundable;
import strategy.ApplicationStrategy;
import strategy.QualificationStrategy;
import strategy.ExperienceStrategy;

public class Day5App {

    public static void main(String[] args) {

        // Runtime polymorphism: parent reference, child objects
        Payment[] payments = {
            new CardPayment(1000),
            new UPIPayment(500),
            new CashPayment(200)
        };

        for (Payment payment : payments) {
            payment.pay();
        }

        // Overloaded pay() method
        payments[0].pay("Recruitment application fee");

        // Interface-based refund
        Refundable refundable = new CardPayment(1000);
        refundable.refund(200);

        // Role hierarchy and overriding
        UserRole[] users = {
            new Recruiter(1, "Ravi", "ravi@example.com"),
            new Candidate(2, "Anu", "anu@example.com")
        };

        for (UserRole user : users) {
            user.displayRole();
        }

        // Strategy pattern: interchangeable implementations
        ApplicationStrategy strategy =
            new QualificationStrategy(70);

        System.out.println(
            "Qualification eligible: "
            + strategy.isEligible(80, 1)
        );

        strategy = new ExperienceStrategy(2);

        System.out.println(
            "Experience eligible: "
            + strategy.isEligible(80, 3)
        );
    }
}

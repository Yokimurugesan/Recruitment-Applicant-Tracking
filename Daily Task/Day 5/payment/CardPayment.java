
package payment;

public class CardPayment extends Payment implements Refundable {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println(
            "Paid Rs. " + getAmount() + " using Card."
        );
    }

    @Override
    public void refund(double amount) {
        if (amount <= 0 || amount > getAmount()) {
            throw new IllegalArgumentException("Invalid refund amount.");
        }
        System.out.println("Card refund initiated: Rs. " + amount);
    }
}

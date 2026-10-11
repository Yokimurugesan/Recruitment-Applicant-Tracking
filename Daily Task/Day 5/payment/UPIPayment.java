
package payment;

public class UPIPayment extends Payment implements Refundable {

    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println(
            "Paid Rs. " + getAmount() + " using UPI."
        );
    }

    @Override
    public void refund(double amount) {
        if (amount <= 0 || amount > getAmount()) {
            throw new IllegalArgumentException("Invalid refund amount.");
        }
        System.out.println("UPI refund initiated: Rs. " + amount);
    }
}

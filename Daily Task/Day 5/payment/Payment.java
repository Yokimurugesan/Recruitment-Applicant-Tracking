
package payment;

public abstract class Payment {

    private double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Payment amount must be positive."
            );
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void pay();

    public void pay(String description) {
        System.out.println(description + ": Rs. " + amount);
        pay();
    }
}

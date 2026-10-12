package service;

import exception.InsufficientStockException;
import exception.InvalidQuantityException;

public class OrderProcessor {

    private int stock = 10;

    public void processOrder(String product, int quantity)
            throws InsufficientStockException {

        try {
            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than zero.");
            }

            if (quantity > stock) {
                throw new InsufficientStockException(
                        "Insufficient stock. Available: " + stock
                                + ", requested: " + quantity);
            }

            stock -= quantity;

            System.out.println("Order successful!");
            System.out.println("Product: " + product);
            System.out.println("Quantity: " + quantity);
            System.out.println("Remaining stock: " + stock);

        } catch (InvalidQuantityException e) {
            throw e;
        } catch (InsufficientStockException e) {
            throw new InsufficientStockException(
                    "Unable to process order for " + product, e);
        } finally {
            System.out.println("Order processing audit completed.");
        }
    }

    public int getStock() {
        return stock;
    }
}

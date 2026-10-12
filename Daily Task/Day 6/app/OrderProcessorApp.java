package app;

import java.util.Scanner;
import service.OrderProcessor;
import exception.InsufficientStockException;
import exception.InvalidQuantityException;

public class OrderProcessorApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderProcessor processor = new OrderProcessor();

        while (true) {
            System.out.println("\n=== Order Processing Menu ===");
            System.out.println("1. Place order");
            System.out.println("2. View available stock");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String product = sc.nextLine();

                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        try {
                            processor.processOrder(product, quantity);
                        } catch (InsufficientStockException
                                 | InvalidQuantityException e) {
                            System.out.println("Order failed: " + e.getMessage());
                            e.printStackTrace();

                            if (e.getCause() != null) {
                                System.out.println(
                                        "Original cause: " + e.getCause().getMessage());
                            }
                        }
                        break;

                    case 2:
                        System.out.println(
                                "Available stock: " + processor.getStock());
                        break;

                    case 3:
                        System.out.println("Exiting application.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid menu choice. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}

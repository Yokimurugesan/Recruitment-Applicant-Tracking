package com.training.atm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class AtmSimulator {

    private static final int CORRECT_PIN = 1234;
    private static double balance = 1000.00;
    private static final List<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the environment selected by Maven
        Properties properties = new Properties();

        try (InputStream input = AtmSimulator.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            System.out.println("Could not read environment settings.");
        }

        String environment = properties.getProperty(
                "app.environment", "development");

        System.out.println("ATM Simulator");
        System.out.println("Environment: " + environment);

        boolean authenticated = false;

        // Allow only 3 PIN attempts
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter your 4-digit PIN: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter numbers only.");
                sc.nextLine();
                continue;
            }

            int pin = sc.nextInt();

            if (pin == CORRECT_PIN) {
                authenticated = true;
                break;
            }

            System.out.println("Incorrect PIN. Attempts remaining: "
                    + (3 - attempt));
        }

        if (!authenticated) {
            System.out.println("Too many attempts. Exiting ATM.");
            sc.close();
            return;
        }

        int choice = 0; 

        // Display the menu until the user chooses Exit
        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Enter a number from 1 to 5.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Balance: Rs. %.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        sc.nextLine();
                        break;
                    }

                    double deposit = sc.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Amount must be greater than zero.");
                        break;
                    }

                    balance += deposit;
                    transactions.add("Deposited Rs. " + deposit);
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        sc.nextLine();
                        break;
                    }

                    double withdrawal = sc.nextDouble();

                    if (withdrawal <= 0) {
                        System.out.println("Amount must be greater than zero.");
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        transactions.add("Withdrew Rs. " + withdrawal);
                        System.out.println("Withdrawal successful.");
                    }
                    break;

                case 4:
                    System.out.println("--- MINI STATEMENT ---");

                    if (transactions.isEmpty()) {
                        System.out.println("No transactions yet.");
                    }

                    // Enhanced for loop
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Choose 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
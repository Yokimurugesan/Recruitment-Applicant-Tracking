package app;

import java.util.Scanner;
import model.BankAccount;
import service.BankAccountService;

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount(
                "Yokeshwari", "ACC101", 1000.00
        );

        BankAccountService service = new BankAccountService();

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. View Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account Counter");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
                choice = 0;
                continue;
            }

            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        service.displayAccount(account);
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double deposit = scanner.nextDouble();
                        service.deposit(account, deposit);
                        System.out.println("Deposit successful.");
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawal = scanner.nextDouble();
                        service.withdraw(account, withdrawal);
                        System.out.println("Withdrawal successful.");
                        break;

                    case 4:
                        System.out.println(
                                "Total accounts created: "
                                        + BankAccount.getAccountCounter()
                        );
                        break;

                    case 5:
                        System.out.println("Thank you for using the bank.");
                        break;

                    default:
                        System.out.println("Invalid menu choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        scanner.close();
    }
}
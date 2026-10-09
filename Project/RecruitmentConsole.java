
import java.util.Scanner;

public class RecruitmentConsole {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n=== Recruitment Applicant Tracking System ===");
            System.out.println("1. Applicant Registration");
            System.out.println("2. View Applicant Details");
            System.out.println("3. Job Application Tracking");
            System.out.println("4. Recruitment Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number from 1 to 5.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Applicant Registration selected.");
                    break;
                case 2:
                    System.out.println("View Applicant Details selected.");
                    break;
                case 3:
                    System.out.println("Job Application Tracking selected.");
                    break;
                case 4:
                    System.out.println("Recruitment Status selected.");
                    break;
                case 5:
                    System.out.println("Exiting Recruitment System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
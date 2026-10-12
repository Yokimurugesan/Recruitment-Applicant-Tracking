
package ats.app;

import ats.model.*;
import ats.service.RecruitmentService;
import ats.exception.InvalidApplicationException;

import java.util.Scanner;

public class ATSApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RecruitmentService service = new RecruitmentService();

        // Sample candidate for the live demonstration
        service.registerCandidate(
                new Candidate(1, "Anu", "anu@example.com",
                        "Java, SQL", "anu_resume.pdf"));

        boolean running = true;

        try {
            while (running) {
                System.out.println("\n==================================");
                System.out.println(" RECRUITMENT APPLICANT TRACKING SYSTEM");
                System.out.println("==================================");
                System.out.println("1. View available jobs");
                System.out.println("2. Register candidate");
                System.out.println("3. View candidates");
                System.out.println("4. Apply for a job");
                System.out.println("5. View applications");
                System.out.println("6. Move application stage");
                System.out.println("7. Process next recruiter review");
                System.out.println("8. Withdraw application");
                System.out.println("9. Hiring funnel report");
                System.out.println("10. Close a job");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                int choice;

                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid menu number.");
                    continue;
                }

                try {
                    switch (choice) {
                        case 1:
                            service.showJobs();
                            break;

                        case 2:
                            System.out.print("Candidate ID: ");
                            int candidateId = Integer.parseInt(
                                    scanner.nextLine().trim());

                            System.out.print("Candidate name: ");
                            String name = scanner.nextLine().trim();

                            System.out.print("Email: ");
                            String email = scanner.nextLine().trim();

                            System.out.print("Skills: ");
                            String skills = scanner.nextLine().trim();

                            System.out.print("Resume filename: ");
                            String resume = scanner.nextLine().trim();

                            if (name.isBlank() || email.isBlank()
                                    || skills.isBlank() || resume.isBlank()) {
                                System.out.println(
                                        "All fields are required.");
                                break;
                            }

                            service.registerCandidate(
                                    new Candidate(candidateId, name, email,
                                            skills, resume));
                            break;

                        case 3:
                            service.showCandidates();
                            break;

                        case 4:
                            System.out.print("Candidate ID: ");
                            int applicantId = Integer.parseInt(
                                    scanner.nextLine().trim());

                            System.out.print("Job ID (101, 102, 103): ");
                            int jobId = Integer.parseInt(
                                    scanner.nextLine().trim());

                            service.applyForJob(applicantId, jobId);
                            break;

                        case 5:
                            service.showApplications();
                            break;

                        case 6:
                            System.out.print("Application ID: ");
                            int appId = Integer.parseInt(
                                    scanner.nextLine().trim());

                            System.out.println(
                                    "Stages: SCREENING, INTERVIEW, OFFER, REJECTED");

                            System.out.print("New stage: ");
                            Application.Stage stage =
                                    Application.Stage.valueOf(
                                            scanner.nextLine().trim()
                                                    .toUpperCase());

                            service.moveApplication(appId, stage);
                            break;

                        case 7:
                            service.processNextReview();
                            break;

                        case 8:
                            System.out.print("Application ID to withdraw: ");
                            int withdrawId = Integer.parseInt(
                                    scanner.nextLine().trim());

                            service.withdrawApplication(withdrawId);
                            break;

                        case 9:
                            service.showHiringReport();
                            break;

                        case 10:
                            System.out.print("Job ID to close: ");
                            int closeId = Integer.parseInt(
                                    scanner.nextLine().trim());

                            service.closeJob(closeId);
                            break;

                        case 0:
                            running = false;
                            System.out.println("ATS application closed.");
                            break;

                        default:
                            System.out.println("Invalid menu choice.");
                    }

                } catch (InvalidApplicationException e) {
                    System.out.println("Application error: "
                            + e.getMessage());

                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Invalid input or stage name. Please try again.");

                } catch (Exception e) {
                    System.out.println("Operation failed: "
                            + e.getMessage());
                }

            }
        } finally {
            scanner.close();
            System.out.println("Resources released.");
        }
    }
}

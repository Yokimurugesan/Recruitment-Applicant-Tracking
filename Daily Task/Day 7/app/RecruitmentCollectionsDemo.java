
package app;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.ArrayDeque;

public class RecruitmentCollectionsDemo {

    // FR1: Job catalogue.
    // ArrayList preserves insertion order and supports indexed access.
    private static final List<String> jobs = new ArrayList<>();

    // FR2: Applications.
    // LinkedHashSet prevents duplicate application keys and preserves order.
    private static final Set<String> applications = new LinkedHashSet<>();

    // FR3: Recruiter review queue.
    // ArrayDeque processes review requests in FIFO order.
    private static final Queue<String> reviewQueue = new ArrayDeque<>();

    public static void main(String[] args) {

        // FR1: Publish jobs.
        jobs.add("J101 - Java Developer");
        jobs.add("J102 - Backend Developer");
        jobs.add("J103 - Data Analyst");

        System.out.println("=== FR1: Available Jobs ===");
        for (String job : jobs) {
            System.out.println(job);
        }

        // FR2: Apply for jobs.
        System.out.println("\n=== FR2: Job Applications ===");
        apply("C101", "J101");
        apply("C102", "J102");
        apply("C101", "J101"); // Duplicate application test.

        // FR3: Queue applications for recruiter review.
        System.out.println("\n=== FR3: Recruiter Review ===");
        reviewQueue.offer("C101 -> J101");
        reviewQueue.offer("C102 -> J102");

        while (!reviewQueue.isEmpty()) {
            System.out.println("Reviewing: " + reviewQueue.poll());
        }
    }

    private static void apply(String candidateId, String jobId) {
        String applicationKey = candidateId + "|" + jobId;

        if (applications.add(applicationKey)) {
            System.out.println(
                    candidateId + " applied for " + jobId);
        } else {
            System.out.println(
                    "Duplicate rejected: " + candidateId + " / " + jobId);
        }
    }
}

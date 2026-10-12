
package ats.service;

import ats.model.*;
import ats.exception.InvalidApplicationException;

import java.util.*;

public class RecruitmentService {

    private final List<Job> jobs = new ArrayList<>();
    private final List<Candidate> candidates = new ArrayList<>();
    private final List<Application> applications = new ArrayList<>();

    // LinkedHashSet prevents duplicate candidate-job pairs
    // and preserves insertion order.
    private final Set<String> applicationKeys = new LinkedHashSet<>();

    // ArrayDeque provides FIFO recruiter review.
    private final Queue<Integer> reviewQueue = new ArrayDeque<>();

    private int nextApplicationId = 1;

    public RecruitmentService() {
        jobs.add(new Job(101, "Java Developer",
                "Engineering", "Java, SQL", 2));
        jobs.add(new Job(102, "Backend Developer",
                "Engineering", "Java, REST API", 1));
        jobs.add(new Job(103, "Data Analyst",
                "Analytics", "SQL, Python", 2));
    }

    public void showJobs() {
        System.out.println("\n--- Available Jobs ---");

        for (Job job : jobs) {
            if (job.isOpen()) {
                job.displayJob();
            }
        }
    }

    public void showCandidates() {
        System.out.println("\n--- Registered Candidates ---");

        if (candidates.isEmpty()) {
            System.out.println("No candidates registered.");
            return;
        }

        for (Candidate candidate : candidates) {
            candidate.displayDetails();
        }
    }

    public void registerCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate registered successfully.");
    }

    public void applyForJob(int candidateId, int jobId)
            throws InvalidApplicationException {

        Candidate candidate = null;
        Job selectedJob = null;

        for (Candidate c : candidates) {
            if (c.getId() == candidateId) {
                candidate = c;
                break;
            }
        }

        for (Job job : jobs) {
            if (job.getId() == jobId) {
                selectedJob = job;
                break;
            }
        }

        if (candidate == null) {
            throw new InvalidApplicationException(
                    "Candidate not found.");
        }

        if (selectedJob == null || !selectedJob.isOpen()) {
            throw new InvalidApplicationException(
                    "Job not found or closed.");
        }

        String key = candidateId + "-" + jobId;

        if (!applicationKeys.add(key)) {
            throw new InvalidApplicationException(
                    "Duplicate application is not allowed.");
        }

        Application application = new Application(
                nextApplicationId++, candidate, selectedJob);

        applications.add(application);
        reviewQueue.offer(application.getId());

        System.out.println("Application submitted successfully.");
        System.out.println("Application ID: " + application.getId());
    }

    public void showApplications() {
        System.out.println("\n--- Applications ---");

        if (applications.isEmpty()) {
            System.out.println("No applications submitted.");
            return;
        }

        for (Application application : applications) {
            application.displayApplication();
        }
    }

    public void moveApplication(int applicationId,
                                Application.Stage newStage)
            throws InvalidApplicationException {

        for (Application application : applications) {
            if (application.getId() == applicationId) {
                Application.Stage current = application.getStage();

                if (current == Application.Stage.REJECTED
                        || current == Application.Stage.WITHDRAWN
                        || current == Application.Stage.OFFER) {
                    throw new InvalidApplicationException(
                            "This application is in a final stage.");
                }

                if (newStage == Application.Stage.APPLIED
                        || newStage == Application.Stage.WITHDRAWN) {
                    throw new InvalidApplicationException(
                            "This stage change is not allowed here.");
                }

                application.setStage(newStage);
                System.out.println("Application stage updated.");
                return;
            }
        }

        throw new InvalidApplicationException(
                "Application not found.");
    }

    public void processNextReview() {
        Integer id = reviewQueue.poll();

        if (id == null) {
            System.out.println("Recruiter review queue is empty.");
            return;
        }

        System.out.println("Next application for review: " + id);
    }

    public void withdrawApplication(int applicationId)
            throws InvalidApplicationException {

        Iterator<Application> iterator = applications.iterator();

        while (iterator.hasNext()) {
            Application application = iterator.next();

            if (application.getId() == applicationId) {
                if (application.getStage() == Application.Stage.OFFER
                        || application.getStage() == Application.Stage.REJECTED) {
                    throw new InvalidApplicationException(
                            "Cannot withdraw a finalized application.");
                }

                application.setStage(Application.Stage.WITHDRAWN);
                applicationKeys.remove(
                        application.getCandidate().getId()
                        + "-" + application.getJob().getId());

                System.out.println("Application withdrawn.");
                return;
            }
        }

        throw new InvalidApplicationException(
                "Application not found.");
    }

    public void showHiringReport() {
        Map<Application.Stage, Integer> counts =
                new EnumMap<>(Application.Stage.class);

        for (Application.Stage stage : Application.Stage.values()) {
            counts.put(stage, 0);
        }

        for (Application application : applications) {
            counts.put(application.getStage(),
                    counts.get(application.getStage()) + 1);
        }

        System.out.println("\n--- Hiring Funnel Report ---");

        for (Map.Entry<Application.Stage, Integer> entry
                : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Total applications: " + applications.size());
    }

    public void closeJob(int jobId)
            throws InvalidApplicationException {

        for (Job job : jobs) {
            if (job.getId() == jobId) {
                job.closeJob();
                System.out.println("Job closed successfully.");
                return;
            }
        }

        throw new InvalidApplicationException("Job not found.");
    }
}

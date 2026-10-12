
package ats.model;

import java.time.LocalDate;

public class Application {

    public enum Stage {
        APPLIED,
        SCREENING,
        INTERVIEW,
        OFFER,
        REJECTED,
        WITHDRAWN
    }

    private int id;
    private Candidate candidate;
    private Job job;
    private Stage stage;
    private LocalDate appliedDate;

    public Application(int id, Candidate candidate, Job job) {
        this.id = id;
        this.candidate = candidate;
        this.job = job;
        this.stage = Stage.APPLIED;
        this.appliedDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Job getJob() {
        return job;
    }

    public Stage getStage() {
        return stage;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void displayApplication() {
        System.out.println(
            "Application ID: " + id +
            " | Candidate: " + candidate.getName() +
            " | Job: " + job.getTitle() +
            " | Stage: " + stage +
            " | Applied: " + appliedDate
        );
    }
}

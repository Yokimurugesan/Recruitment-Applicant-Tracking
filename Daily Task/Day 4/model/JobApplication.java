package model;

public class JobApplication {
    private int applicationId;
    private Applicant applicant;
    private Job job;
    private String status;

    public JobApplication(int applicationId, Applicant applicant, Job job, String status) {
        this.applicationId = applicationId;
        this.applicant = applicant;
        this.job = job;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public Job getJob() {
        return job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
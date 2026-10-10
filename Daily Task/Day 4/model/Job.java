package model;

public class Job {
    private int jobId;
    private String title;
    private String department;

    public Job(int jobId, String title, String department) {
        this.jobId = jobId;
        this.title = title;
        this.department = department;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }
}
package model;

public class Applicant {
    private int applicantId;
    private String name;
    private String email;

    public Applicant(int applicantId, String name, String email) {
        this.applicantId = applicantId;
        this.name = name;
        this.email = email;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
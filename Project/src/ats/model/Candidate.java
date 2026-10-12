
package ats.model;

public class Candidate extends User {
    private String skills;
    private String resumeFileName;

    public Candidate(int id, String name, String email,
                     String skills, String resumeFileName) {
        super(id, name, email);
        this.skills = skills;
        this.resumeFileName = resumeFileName;
    }

    public String getSkills() {
        return skills;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Candidate Details ---");
        super.displayDetails();
        System.out.println("Skills: " + skills);
        System.out.println("Resume: " + resumeFileName);
    }
}

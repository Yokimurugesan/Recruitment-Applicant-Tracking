
package ats.model;

public class Recruiter extends User {
    private String department;

    public Recruiter(int id, String name, String email,
                     String department) {
        super(id, name, email);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Recruiter Details ---");
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

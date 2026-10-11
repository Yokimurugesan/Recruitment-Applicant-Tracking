
package model;

public class Recruiter extends UserRole {

    public Recruiter(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " is a Recruiter");
    }
}

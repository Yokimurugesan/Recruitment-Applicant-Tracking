
package model;

public class Candidate extends UserRole {

    public Candidate(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " is a Candidate");
    }
}

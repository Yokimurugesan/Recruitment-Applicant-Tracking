
package model;

public abstract class UserRole extends BaseEntity {

    private String name;
    private String email;

    public UserRole(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public abstract void displayRole();
}

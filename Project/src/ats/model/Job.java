
package ats.model;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private int id;
    private String title;
    private String department;
    private String requiredSkills;
    private int vacancies;
    private boolean open;

    public Job(int id, String title, String department,
               String requiredSkills, int vacancies) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.requiredSkills = requiredSkills;
        this.vacancies = vacancies;
        this.open = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public int getVacancies() {
        return vacancies;
    }

    public boolean isOpen() {
        return open;
    }

    public void closeJob() {
        open = false;
    }

    public void displayJob() {
        System.out.println(
            id + " | " + title +
            " | " + department +
            " | Skills: " + requiredSkills +
            " | Vacancies: " + vacancies +
            " | Status: " + (open ? "OPEN" : "CLOSED")
        );
    }
}

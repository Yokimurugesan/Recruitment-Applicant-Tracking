package model;

public class Book {
    private int id;
    private String title;
    private boolean overdue;

    public Book(int id, String title, boolean overdue) {
        this.id = id;
        this.title = title;
        this.overdue = overdue;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isOverdue() {
        return overdue;
    }

    @Override
    public String toString() {
        return "Book ID: " + id
                + ", Title: " + title
                + ", Overdue: " + overdue;
    }
}
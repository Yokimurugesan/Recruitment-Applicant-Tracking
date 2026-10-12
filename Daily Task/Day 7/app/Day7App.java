package app;

import model.Book;
import service.LibraryWaitlist;

public class Day7App {

    public static void main(String[] args) {

        LibraryWaitlist library = new LibraryWaitlist();

        // 1. Add books to the ArrayList catalogue.
        System.out.println("=== ADD BOOKS ===");

        library.addBook(new Book(1, "Java Basics", false));
        library.addBook(new Book(2, "Data Structures", true));
        library.addBook(new Book(3, "Database Systems", false));

        // Test duplicate prevention using LinkedHashSet.
        library.addBook(new Book(4, "Java Basics", false));

        library.showCatalogue();

        // 2. Add ordinary requests to the ArrayDeque waitlist.
        System.out.println("\n=== WAITLIST ===");

        library.addToWaitlist("Yoki");
        library.addToWaitlist("Priya");
        library.addToWaitlist("Divya");

        library.processWaitlist();

        // 3. Faculty requests receive higher priority.
        System.out.println("\n=== PRIORITY REQUESTS ===");

        library.addPriorityRequest("Student: Priya");
        library.addPriorityRequest("Faculty: Professor Kumar");
        library.addPriorityRequest("Student: Divya");
        library.addPriorityRequest("Faculty: Professor Ravi");

        library.processPriorityRequests();

        // 4. Remove overdue books using Iterator.remove().
        library.removeOverdueBooks();

        // 5. Display the remaining catalogue.
        library.showCatalogue();
    }
}
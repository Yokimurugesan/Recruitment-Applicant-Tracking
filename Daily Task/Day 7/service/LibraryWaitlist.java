package service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

import model.Book;

public class LibraryWaitlist {

    // ArrayList: preserves order and supports fast access by index.
    private List<Book> catalogue = new ArrayList<>();

    // LinkedHashSet: prevents duplicate titles and preserves insertion order.
    private Set<String> uniqueBooks = new LinkedHashSet<>();

    // ArrayDeque: efficient FIFO queue for ordinary waitlist requests.
    private Queue<String> waitlist = new ArrayDeque<>();

    // PriorityQueue: faculty requests come before student requests.
    private PriorityQueue<String> priorityRequests =
            new PriorityQueue<>(
                Comparator.comparingInt(request ->
                    request.startsWith("Faculty:") ? 0 : 1)
            );

    public void addBook(Book book) {
        if (uniqueBooks.add(book.getTitle())) {
            catalogue.add(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Duplicate book rejected: " + book.getTitle());
        }
    }

    public void showCatalogue() {
        System.out.println("\n--- Book Catalogue ---");
        for (Book book : catalogue) {
            System.out.println(book);
        }
    }

    public void addToWaitlist(String name) {
        waitlist.offer(name);
        System.out.println(name + " added to waitlist.");
    }

    public void processWaitlist() {
        System.out.println("\n--- FIFO Waitlist ---");
        while (!waitlist.isEmpty()) {
            System.out.println("Serving: " + waitlist.poll());
        }
    }

    public void addPriorityRequest(String request) {
        priorityRequests.offer(request);
    }

    public void processPriorityRequests() {
        System.out.println("\n--- Priority Requests ---");
        while (!priorityRequests.isEmpty()) {
            System.out.println("Processing: " + priorityRequests.poll());
        }
    }

    public void removeOverdueBooks() {
        System.out.println("\n--- Removing Overdue Books ---");

        Iterator<Book> iterator = catalogue.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (book.isOverdue()) {
                iterator.remove();
                uniqueBooks.remove(book.getTitle());
                System.out.println("Removed: " + book.getTitle());
            }
        }
    }
}
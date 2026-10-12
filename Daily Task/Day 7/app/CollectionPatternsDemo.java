
package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CollectionPatternsDemo {

    public static void main(String[] args) {

        // HashSet: stores unique elements; order is not guaranteed.
        Set<Integer> hashSet = new HashSet<>(
                Arrays.asList(30, 10, 20, 10));
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet: unique elements in insertion order.
        Set<Integer> linkedSet = new LinkedHashSet<>(
                Arrays.asList(30, 10, 20, 10));
        System.out.println("LinkedHashSet: " + linkedSet);

        // TreeSet: unique elements sorted in natural order.
        Set<Integer> treeSet = new TreeSet<>(
                Arrays.asList(30, 10, 20, 10));
        System.out.println("TreeSet: " + treeSet);

        // for-each: good for reading elements, not structural removal.
        List<String> names = new ArrayList<>(
                Arrays.asList("Anu", "Bala", "Cathy"));

        System.out.println("\nFor-each:");
        for (String name : names) {
            System.out.println(name);
        }

        // Iterator.remove(): safe removal during iteration.
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("Bala")) {
                iterator.remove();
            }
        }
        System.out.println("After Iterator.remove(): " + names);

        // ListIterator: forward and backward traversal; supports set/add/remove.
        ListIterator<String> listIterator = names.listIterator();

        while (listIterator.hasNext()) {
            String name = listIterator.next();
            if (name.equals("Anu")) {
                listIterator.set("Anu Updated");
            }
        }
        System.out.println("After ListIterator.set(): " + names);

        listIterator = names.listIterator(names.size());
        System.out.println("Backward traversal:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // Demonstrate ConcurrentModificationException.
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4));

        try {
            for (Integer number : numbers) {
                if (number == 2) {
                    numbers.remove(number);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(
                    "\nConcurrentModificationException demonstrated.");
        }

        System.out.println("Use Iterator.remove() for safe removal.");
    }
}

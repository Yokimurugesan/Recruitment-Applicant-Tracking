
package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionTimingDemo {

    private static final int SIZE = 100_000;
    private static volatile long resultSink;

    private static long measureEndInsertion(List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        return System.nanoTime() - start;
    }

    private static long measureMiddleInsertion(List<Integer> list) {
        // Start with the same number of elements for both collections.
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        long start = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            list.add(list.size() / 2, -i);
        }

        return System.nanoTime() - start;
    }

    private static long measureIndexedGet(List<Integer> list) {
        long sum = 0;
        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            sum += list.get(i);
        }

        long elapsed = System.nanoTime() - start;
        resultSink = sum;

        return elapsed;
    }

    public static void main(String[] args) {
        // Warm-up helps reduce some JVM startup effects.
        for (int i = 0; i < 2; i++) {
            measureEndInsertion(new ArrayList<>());
            measureEndInsertion(new LinkedList<>());
        }

        long arrayEnd = measureEndInsertion(new ArrayList<>());
        long linkedEnd = measureEndInsertion(new LinkedList<>());

        long arrayMiddle = measureMiddleInsertion(new ArrayList<>());
        long linkedMiddle = measureMiddleInsertion(new LinkedList<>());

        List<Integer> arrayData = new ArrayList<>();
        List<Integer> linkedData = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            arrayData.add(i);
            linkedData.add(i);
        }

        long arrayGet = measureIndexedGet(arrayData);
        long linkedGet = measureIndexedGet(linkedData);

        System.out.println("\n--- ArrayList vs LinkedList ---");
        System.out.printf("%-25s %15s %15s%n",
                "Operation", "ArrayList (ms)", "LinkedList (ms)");

        printRow("Append " + SIZE + " items", arrayEnd, linkedEnd);
        printRow("100 middle insertions", arrayMiddle, linkedMiddle);
        printRow(SIZE + " indexed get(i)", arrayGet, linkedGet);
    }

    private static void printRow(String operation, long arrayNanos,
                                 long linkedNanos) {
        System.out.printf("%-25s %15.3f %15.3f%n",
                operation,
                arrayNanos / 1_000_000.0,
                linkedNanos / 1_000_000.0);
    }
}

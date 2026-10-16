package app;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionLab {

    static void createTemporaryObjects() {
        List<byte[]> temporary = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            temporary.add(new byte[256 * 1024]);
        }
    }

    public static void main(String[] args) {
        for (int round = 1; round <= 20; round++) {
            createTemporaryObjects();
            System.out.println("Completed allocation round " + round);
        }

        System.gc();

        System.out.println("Experiment completed.");
    }
}
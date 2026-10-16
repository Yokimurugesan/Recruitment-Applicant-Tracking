package app;

import java.util.ArrayList;
import java.util.List;

public class HeapMemoryLab {

    public static void main(String[] args) {
        List<byte[]> memory = new ArrayList<>();
        long totalMB = 0;

        try {
            while (true) {
                byte[] block = new byte[1024 * 1024];
                memory.add(block);
                totalMB++;
                System.out.println("Allocated approximately " + totalMB + " MB");
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Heap memory exhausted!");
            System.out.println("Approximate MB retained: " + totalMB);
        }
    }
}
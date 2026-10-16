package app;

public class StringPerformanceLab {

    public static void main(String[] args) {
        int count = 20_000;

        long start = System.nanoTime();
        String text = "";

        for (int i = 0; i < count; i++) {
            text += i;
        }

        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(i);
        }

        StringBuilder result = builder;
        long builderTime = System.nanoTime() - start;

        System.out.println("Characters created: " + text.length());
        System.out.println("String += time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder time: " + builderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder characters: " + result.length());
    }
}
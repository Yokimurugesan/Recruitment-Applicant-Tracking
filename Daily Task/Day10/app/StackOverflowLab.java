package app;

public class StackOverflowLab {

    static int count = 0;

    static void recurse() {
        count++;
        recurse();
    }

    public static void main(String[] args) {
        try {
            recurse();
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow occurred!");
            System.out.println("Recursive calls before overflow: " + count);
        }
    }
}
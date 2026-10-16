package app;

public class IntegerCacheLab {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;

        Integer c = 128;
        Integer d = 128;

        System.out.println("127 using == : " + (a == b));
        System.out.println("128 using == : " + (c == d));

        System.out.println("128 using equals(): " + c.equals(d));
    }
}
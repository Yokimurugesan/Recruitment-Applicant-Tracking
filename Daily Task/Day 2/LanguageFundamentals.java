public class LanguageFundamentals {

    public static void main(String[] args) {

        // Primitive data types
        byte byteValue = 10;
        short shortValue = 1000;
        int intValue = 50000;
        long longValue = 500000L;
        float floatValue = 10.5f;
        double doubleValue = 20.25;
        char grade = 'A';
        boolean passed = true;

        // Widening casting
        double widenedValue = intValue;

        // Narrowing casting
        int narrowedValue = (int) doubleValue;

        // Operator precedence
        int result = 10 + 5 * 2;

        // Overflow demonstration
        int maxInt = Integer.MAX_VALUE;
        long safeValue = (long) maxInt + 1;

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: " + grade);
        System.out.println("boolean: " + passed);

        System.out.println("Widened value: " + widenedValue);
        System.out.println("Narrowed value: " + narrowedValue);
        System.out.println("Operator result: " + result);
        System.out.println("Safe long value: " + safeValue);
    }
}

public class ControlFlowDemo {

    public static void main(String[] args) {

        // 1. if-else
        int number = 7;

        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }

        // 2. switch
        int day = 2;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Other day");
        }

        // 3. while loop
        int count = 1;

        while (count <= 3) {
            System.out.println("Count: " + count);
            count++;
        }

        // 4. for loop, continue and break
        for (int i = 1; i <= 5; i++) {
            if (i == 2) {
                continue;
            }

            if (i == 5) {
                break;
            }

            System.out.println("Number: " + i);
        }

        // 5. Enhanced for loop
        int[] numbers = {10, 20, 30};

        for (int value : numbers) {
            System.out.println("Value: " + value);
        }

        // 6. Labelled break
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outer;
                }

                System.out.println(i + ", " + j);
            }
        }
    }
}
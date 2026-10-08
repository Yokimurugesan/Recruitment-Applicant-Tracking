public class MonthlyUsageAnalyser {

    // Slab limits
    static final int SLAB_1_LIMIT = 100;
    static final int SLAB_2_LIMIT = 200;

    // Slab rates
    static final int SLAB_1_RATE = 5;
    static final int SLAB_2_RATE = 7;
    static final int SLAB_3_RATE = 10;

    public static void main(String[] args) {

        // 1-D array: usage for 12 months
        int[] monthlyUsage = {
            120, 150, 180, 200,
            250, 300, 280, 220,
            190, 160, 140, 130
        };

        // Calculate total
        long totalUsage = 0;

        for (int usage : monthlyUsage) {
            totalUsage += usage;
        }

        // Calculate average
        double averageUsage = (double) totalUsage / monthlyUsage.length;

        // Cast double to int
        int averageAsInt = (int) averageUsage;

        // Find maximum and minimum
        int maxUsage = monthlyUsage[0];
        int minUsage = monthlyUsage[0];

        for (int usage : monthlyUsage) {

            if (usage > maxUsage) {
                maxUsage = usage;
            }

            if (usage < minUsage) {
                minUsage = usage;
            }
        }

        // Grade using ternary operator
        char grade = averageUsage >= 250 ? 'A'
                   : averageUsage >= 200 ? 'B'
                   : averageUsage >= 150 ? 'C'
                   : 'D';

        // Display results
        System.out.println("===== Monthly Usage Analyser =====");
        System.out.println("Total Usage       : " + totalUsage);
        System.out.println("Average Usage     : " + averageUsage);
        System.out.println("Average as Integer: " + averageAsInt);
        System.out.println("Maximum Usage     : " + maxUsage);
        System.out.println("Minimum Usage     : " + minUsage);
        System.out.println("Grade             : " + grade);

        // 2-D array: usage of 3 houses
        int[][] houseUsage = {
            {120, 150, 180},
            {200, 220, 250},
            {300, 280, 270}
        };

        System.out.println("\n===== Three Houses Usage =====");

        for (int i = 0; i < houseUsage.length; i++) {
            System.out.print("House " + (i + 1) + ": ");

            for (int j = 0; j < houseUsage[i].length; j++) {
                System.out.print(houseUsage[i][j] + " ");
            }

            System.out.println();
        }

        // Slab calculation example
        int usage = 250;
        int rate;

        if (usage <= SLAB_1_LIMIT) {
            rate = SLAB_1_RATE;
        } else if (usage <= SLAB_2_LIMIT) {
            rate = SLAB_2_RATE;
        } else {
            rate = SLAB_3_RATE;
        }

        System.out.println("\nUsage: " + usage);
        System.out.println("Applicable Rate: " + rate);

        // Floating-point precision example
        double result = 0.1 + 0.2;

        System.out.println("0.1 + 0.2 = " + result);
    }
}
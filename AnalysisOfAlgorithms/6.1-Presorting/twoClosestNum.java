import java.util.Arrays;

public class twoClosestNum {
    /*
     * Problem:
     * Find the distance between the two closest numbers in an array of n numbers.
     * The distance between x and y is |x - y|.
     *
     * TODO:
     * a. Design a presorting-based algorithm and determine its efficiency class.
     * b. Compare its efficiency with the brute-force algorithm.
     */

    public static int closestDistancePresort(int[] numbers) {
        validateInput(numbers);

        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);

        int length = sorted.length;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < length - 1; i++) {
            int diff = Math.abs(sorted[i + 1] - sorted[i]);

            if (diff < minDiff) minDiff = diff;
        }

        return minDiff;
    }

    public static int closestDistanceBruteForce(int[] numbers) {
        validateInput(numbers);

        int length = numbers.length;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);

                if (diff < minDiff) minDiff = diff;
            }
        }

        return minDiff;
    }

    private static void validateInput(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two numbers.");
        }
    }

    public static void main(String[] args) {
        int[] sample = { 8, 3, 15, 10, 4 };

        System.out.println("Input: " + Arrays.toString(sample));
        System.out.println("Closest distance with presorting: " + closestDistancePresort(sample));
        System.out.println("Closest distance with brute force: " + closestDistanceBruteForce(sample));

        System.out.println("Presorting efficiency: O(n log n)");
        System.out.println("Brute-force efficiency: O(n^2)");
    }
}

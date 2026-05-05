package dev.ntokozo.kata.list;

public class SlidingWindow {

    public int findMaxSum(int[] numbers, int window) {
        int size = numbers.length;

        if (size < window)
            return  -1;

        int windowSum = 0;
        for (int i = 0; i < window; i++)
            windowSum += numbers[i];

        int maxSum = windowSum;

        for (int i = window; i < size; i++) {
            windowSum += numbers[i] - numbers[i - window];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public double findMaxAverage(int[] numbers, int window) {
        int size = numbers.length;

        if (window > size)
            return -1;

        double windowSum = 0;
        for (int i = 0; i < window; i++)
            windowSum += numbers[i];

        double averageSum = windowSum / window;

        for (int i = window; i < size; i++) {
            windowSum += numbers[i] - numbers[i - window];
            averageSum = Math.max(windowSum / window, averageSum);
        }

        return  averageSum;
    }

    public int findSmallestSubarray(int targetSum, int[] numbers) {
        // Initialize with a value larger than any possible array length
        int minLength = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;

        // 'windowEnd' is the Head of the Caterpillar
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            // Step 1: Grow - Add the next element to the sum
            currentWindowSum += numbers[windowEnd];

            // Step 2: Shrink - While sum meets the target, try to find a smaller window
            while (currentWindowSum >= targetSum) {
                // Update the minimum length found so far
                // (windowEnd - windowStart + 1) calculates the current size
                minLength = Math.min(minLength, windowEnd - windowStart + 1);

                // Pull the Tail: subtract the starting element and move forward
                currentWindowSum -= numbers[windowStart];
                windowStart++;
            }
        }

        // If minLength was never updated, return 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
package dev.ntokozo.kata.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingWindowTest {
    private static final SlidingWindow list = new SlidingWindow();

    @Test
    void maxContiguousSum_shouldReturnMaximumWindowSum(){
        // Arrange
        var integers = new int[] { 2, 1, 5, 1, 3, 2 };
        var windowSize = 3;
        var expected = 9;
        // Act
        int result = list.findMaxSum(integers, windowSize);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void findMaxAverage() {
        // Arrange
        int[] nums = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        double expected = 12.75000;
        // Act
        var result = list.findMaxAverage(nums, k);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void findSmallestSubarray() {
        // Arrange
        int targetSum = 7;
        int[] numbers = new int[] {2, 1, 5, 2, 3, 2};
        int expected = 2;
        // Act
        var result = list.findSmallestSubarray(targetSum, numbers);
        // Assert
        assertEquals(expected, result);
    }
}

package dev.ntokozo.kata.trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TreeCalculatorTest {
    private final TreeCalculator calculator = new TreeCalculator();

    @Test
    void givenNullRoot_shouldReturnZero() {
        var expected = 0;
        var result = calculator.sumOfEvenNodes(null);

        assertEquals(expected, result);
    }

    @Test
    void givenOnlyOddRoot_shouldReturnZero() {
        Node root = new Node(7);
        var expected = 0;
        var result = calculator.sumOfEvenNodes(root);

        assertEquals(expected, result);
    }

    @Test
    void givenOnlyEvenRoot_shouldReturnVal() {
        int value = 10;
        Node root = new Node(value);
        var result = calculator.sumOfEvenNodes(root);

        assertEquals(value, result);
    }

    @Test
    void givenMixedTree_shouldReturnCorrectSum() {
        //      4
        //     / \
        //    2   5
        //   /     \
        //  3       6
        // Expected: 4 + 2 + 6 = 12
        var expected = 12;
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.right.right = new Node(6);
        var result = calculator.sumOfEvenNodes(root);

        assertEquals(expected, result);
    }

    @Test
    void givenSkewedTreeOfEvens_shouldReturnSum() {
        // 2 -> 4 -> 6
        Node root = new Node(2);
        root.right = new Node(4);
        root.right.right = new Node(6);
        var expected = 12;
        var result = calculator.sumOfEvenNodes(root);

        assertEquals(expected, result);
    }
}
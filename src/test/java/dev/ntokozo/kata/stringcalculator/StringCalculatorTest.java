package dev.ntokozo.kata.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private static final StringCalculator calculator = new StringCalculator();

    @Test
    public void givenEmptyString_shouldReturnZero() {
        // Arrange
        var input = "";
        var expected = 0;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenSingleNumber_shouldReturnItself() {
        // Arrange
        var input = "1";
        var expected = 1;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenTwoNumbers_shouldReturnTheirSum() {
        // Arrange
        var input = "1,2";
        var expected = 3;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenMultipleNumbers_shouldReturnTheirSum() {
        // Arrange
        var input = "1,3,4";
        var expected = 8;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenNewLines_shouldReturnTheSum() {
        // Arrange
        var input = "1,2\n3";
        var expected = 6;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenCustomDelimiters_shouldReturnTheSum() {
        // Arrange
        var input = "//;\n1;2";
        var expected = 3;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenNegativeNumber_shouldThrowException() {
        // Arrange
        var input  = "1,-1,-2";
        // Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                ()-> calculator.add(input));
        // Assert
        assertEquals("negatives not allowed: -1, -2", exception.getMessage());
    }
}

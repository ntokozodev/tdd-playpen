package dev.ntokozo.kata.stringcalculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTwoTest {
    private static final StringCalculatorTwo calculator = new StringCalculatorTwo();

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
        var input = "2";
        var expected = 2;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenTwoNumbers_shouldReturnTheirSum() {
        // Arrange
        var input = "1,3";
        var expected = 4;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenMultipleNumbers_shouldReturnTheirSum() {
        // Arrange
        var input = "1,2,4";
        var expected = 7;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenNewLines_shouldReturnTheSum() {
        // Arrange
        var input = "1,3\n5";
        var expected = 9;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenCustomDelimiters_shouldReturnTheSum() {
        // Arrange
        var input = "//;\n1;7";
        var expected = 8;
        // Act
        var result = calculator.add(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void givenNegativeNumber_shouldThrowException() {
        // Arrange
        var input = "1,-1,-2";
        var expected = "Negatives not allowed: -1, -2";
        // Act
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.add(input));
        // Assert
        assertEquals(expected, exception.getMessage());
    }
}


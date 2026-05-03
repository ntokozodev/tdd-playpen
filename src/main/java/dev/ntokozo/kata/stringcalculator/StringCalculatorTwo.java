package dev.ntokozo.kata.stringcalculator;

import java.util.ArrayList;

public class StringCalculatorTwo {
    public int add(String input) {
        if (input == null || input.isEmpty())
            return 0;

        var delimiters = "[,|\n]";
        var numbers = input;

        if (input.startsWith("//")) {
            var newlineIndex = input.indexOf("\n");
            delimiters = input.substring(newlineIndex - 1, newlineIndex);
            numbers = input.substring(newlineIndex + 1);
        }

        return calculateSum(numbers, delimiters);
    }

    private static int calculateSum(String numbers, String delimiters) {
        var tokens = numbers.split(delimiters);
        var negatives = new ArrayList<String>();
        var positiveSum = 0;

        for (String token : tokens) {
            if (token.isEmpty())
                continue;

            if (token.startsWith("-"))
                negatives.add(token);
            else
                positiveSum += Integer.parseInt(token);
        }

        if (!negatives.isEmpty()) {
            var exception = "Negatives not allowed: " + String.join(", ", negatives);
            throw new IllegalArgumentException(exception);
        }

        return positiveSum;
    }
}

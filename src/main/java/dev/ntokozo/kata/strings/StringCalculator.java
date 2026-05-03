package dev.ntokozo.kata.strings;

import java.util.Optional;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        if (input.length() == 1)
        {
            int num = Integer.parseInt(input);
            if (num < 0)
                throw new IllegalArgumentException("negatives not allowed: " + num);
            return num;
        }

        var negatives = new StringBuilder();
        var numbers = input.split("[,|\n]");
        var sum = 0;
        for (String number : numbers)
        {
            int num = tryParse(number).orElse(0);
            if (num < 0)
            {
                if (negatives.isEmpty() )
                    negatives.append(number);
                else
                    negatives.append(", ").append(number);
                continue;
            }

            if (!negatives.isEmpty())
                continue;

            if (num == 0)
            {
                sum = 0;
                break;
            }

            sum += num;
        }

        if (!negatives.isEmpty())
            throw new IllegalArgumentException("negatives not allowed: " + negatives.toString());

        if (sum > 0)
            return sum;

        boolean hasCustomDelimiters = input.startsWith("//");
        if (hasCustomDelimiters) {
            var delimiter = input.substring(2, 3);
            var numbersStartIndex = input.indexOf("\n");
            var customDelimiterSplit = input.substring(numbersStartIndex+1).split(delimiter);

            for (String number: customDelimiterSplit)
                sum += Integer.parseInt(number);

            return sum;
        }

        return sum;
    }

    private static Optional<Integer> tryParse(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

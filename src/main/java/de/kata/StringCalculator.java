package de.kata;

public class StringCalculator {

    public static final String REGEX = ",|\n";

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;

        for (String splittedNumber : split(numbers)) {
            sum += Integer.parseInt(splittedNumber);
        }

        return sum;
    }

    private String[] split(String numbers) {
        return numbers.split(REGEX);
    }
}

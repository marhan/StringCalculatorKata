package de.kata;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] splittedNumbers = numbers.split(",");
        for (String splittedNumber : splittedNumbers) {
            sum += Integer.parseInt(splittedNumber);
        }

        return sum;
    }
}

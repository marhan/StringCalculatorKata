package de.kata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        String separatorRegex = ",|\n";

        if (input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            String separator = extractSeparator(input);
            separatorRegex = addNewSeparator(separatorRegex, separator);
            input = removeControl(input);
        }

        String[] numbers = input.split(separatorRegex);

        return computeSum(numbers);
    }

    private int computeSum(String[] numbers) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<Integer>();
        for (String number : numbers) {
            int convertedNumber = Integer.parseInt(number);
            if (convertedNumber < 0) {
                negatives.add(convertedNumber);
            }

            sum += convertedNumber;
        }

        if (!negatives.isEmpty()) {
            return buildExceptionMessageAndThrow(negatives);
        }

        return sum;
    }

    private String addNewSeparator(String separatorRegex, String separator) {
        separatorRegex = separatorRegex.concat("|").concat(separator);
        return separatorRegex;
    }

    private String extractSeparator(String input) {
        int endOfControl = findEndOfControl(input);
        return input.substring(0, endOfControl).replace("//", "").replace("\n", "");
    }

    private int findEndOfControl(String input) {
        return input.indexOf("\n") + 1;
    }

    private String removeControl(String input) {
        int endOfControl = findEndOfControl(input);
        return input.substring(endOfControl, input.length());
    }

    private int buildExceptionMessageAndThrow(List<Integer> negatives) {
        StringBuilder builder = new StringBuilder();

        Iterator<Integer> iterator = negatives.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
            if (iterator.hasNext()) {
                builder.append(",");
            }
        }
        throw new RuntimeException("negatives not allowed: " + builder.toString());
    }
}

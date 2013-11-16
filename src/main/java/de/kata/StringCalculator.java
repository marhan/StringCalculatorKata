package de.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author markus.hanses
 */
public class StringCalculator {

	public int add(String numbers) {
		ArrayList<String> delimiters = new ArrayList<String>();
		delimiters.add("\n");
		delimiters.add(",");

		List<String> negatives = new ArrayList<String>();
		int sum = 0;

		if (numbers == null || numbers.isEmpty()) {
			// do nothing
		} else if (numbers.startsWith("//")) {
			String withoutControlChar = numbers.replace("//", "");
			String delimiter = String.valueOf(withoutControlChar.charAt(0));
			String withoutNewLine = withoutControlChar.replace(delimiter + "\n", "");
			delimiters.add(delimiter);
			for (String number : split(delimiters, withoutNewLine)) {
				int converted = toInt(number);
				if (converted < 0) {
					negatives.add(String.valueOf(converted));
				}
				sum += converted;
			}
		} else {
			for (String number : split(delimiters, numbers)) {
				int converted = toInt(number);
				if (converted < 0) {
					negatives.add(String.valueOf(converted));
				}
				sum += converted;
			}
		}

		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + join(negatives));

		}
		return sum;
	}

	private String join(List<String> negatives) {
		StringBuilder builder = new StringBuilder();
		Iterator<String> iterator = negatives.iterator();
		while (iterator.hasNext()) {
			builder.append(iterator.next());
			if (iterator.hasNext()) {
				builder.append(",");
			}
		}
		return builder.toString();
	}

	private List<String> split(List<String> delimiters, String... numbers) {
		List<String> numberList = new ArrayList<String>(0);
		for (String number : numbers) {
			for (String splittedNumbers : splitWithDelimiter(delimiters.get(0), number)) {
				numberList.add(splittedNumbers);
			}
		}
		delimiters.remove(0);
		if (!delimiters.isEmpty()) {
			numberList = split(delimiters, numberList.toArray(new String[0]));
		}
		return numberList;
	}

	private List<String> splitWithDelimiter(String delimiterTwo, String firstSplit) {
		return Arrays.asList(firstSplit.split(delimiterTwo));
	}

	private int toInt(String number) {
		return Integer.parseInt(number);
	}
}

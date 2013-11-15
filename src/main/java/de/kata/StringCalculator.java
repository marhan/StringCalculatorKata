package de.kata;

/**
 * @author markus.hanses
 */
public class StringCalculator {

	public int add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		} else if (numbers.contains(",")) {
			int sum = 0;
			for (String number : numbers.split(",")) {
				sum += toInt(number);
			}
			return sum;
		} else {
			return toInt(numbers);
		}
	}

	private int toInt(String number) {
		return Integer.parseInt(number);
	}
}

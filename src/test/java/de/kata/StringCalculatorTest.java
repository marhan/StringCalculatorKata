package de.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author markus.hanses
 */
public class StringCalculatorTest {

	private StringCalculator subject;

	@Before
	public void setup() {
		subject = new StringCalculator();
	}

	@Test
	public void emptyStringResultsToZero() {
		assertThat(subject.add(""), is(0));
	}

	@Test
	public void nullResultsToZero() {
		assertThat(subject.add(null), is(0));
	}

	@Test
	public void oneGivenNumberIsReturned() {
		assertThat(subject.add("1"), is(1));
	}

	@Test
	public void twoCommaSeparatedNumbersWillReturnedAsSum() {
		assertThat(subject.add("1,2"), is(3));
	}

	@Test
	public void anyCommaSeparatedNumbersWillReturnedAsSum() {
		assertThat(subject.add("1,2,3,4,5,6,7,8"), is(36));
	}

	@Test
	public void twoNewLineSeparatedNumberWillReturnedAsSum() {
		assertThat(subject.add("1\n2"), is(3));
	}

	@Test
	public void anyCommaAndNewLineSeparatedNumberWillReturnedAsSum() {
		assertThat(subject.add("1,2\n3"), is(6));
	}

	@Test
	public void anyDelimiterSeparatedNumberWillReturnedAsSum() {
		assertThat(subject.add("//;\n1;2"), is(3));
	}

	@Test
	public void negativeNumberWillOccurException() {
		try {
			subject.add("-1");
			fail("exception expected");
		} catch (Exception e) {
			assertThat(e.getMessage(), containsString("negatives not allowed"));
		}
	}

	@Test
	public void negativeNumbersWillOccurExceptionAndContainedInMessage() {
		try {
			subject.add("-1,1,-2");
			fail("exception expected");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("negatives not allowed: -1,-2"));
		}
	}
}

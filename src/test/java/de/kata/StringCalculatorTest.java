package de.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    private StringCalculator subject;

    @Before
    public void setup() {
        subject = new StringCalculator();
    }

    @Test
    public void whenNullGivenThanZeroReturned() {
        int number = subject.add(null);
        assertThat(number, is(0));
    }

    @Test
    public void whenEmptyStringGivenThanZeroReturned() {
        int number = subject.add("");
        assertThat(number, is(0));
    }

    @Test
    public void whenNumberOneGivenThanOneReturned() {
        int number = subject.add("1");
        assertThat(number, is(1));
    }

    @Test
    public void whenNumberTwoGivenThanTwoReturned() {
        int number = subject.add("2");
        assertThat(number, is(2));
    }

    @Test
    public void whenTwoNumbersCommaSeparatedGivenThanSumReturned() {
        int sum = subject.add("1,2");
        assertThat(sum, is(3));
    }

    @Test
    public void whenManyNumberCommaSeparatedGivenThanSumReturned() {
        int sum = subject.add("1,2,3,4,5,6,7,8,9");
        assertThat(sum, is(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9));
    }

    @Test
    public void whenManyNumbersNewLineSeparatedGivenThanSumReturned() {
        int sum = subject.add("2\n5,10");
        assertThat(sum, is(17));
    }

}

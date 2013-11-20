package de.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    private StringCalculator subject;

    @Before
    public void setup() {
        subject = new StringCalculator();
    }

    @Test
    public void givenIsAnEmptyStringThenZeroIsReturned() {
        assertThat(subject.add(""), is(0));
    }

    @Test
    public void givenIsANumberThenTheNumberWillBeReturned() {
        assertThat(subject.add("1"), is(1));
    }

    @Test
    public void givenAreCommaSeparatedNumbersThenTheSumIsReturned() {
        assertThat(subject.add("1,2"), is(3));
    }

    @Test
    public void givenAreManyCommaSeparatedNumbersThenSumIsReturned() {
        assertThat(subject.add("10,12,33"), is(55));
    }

    @Test
    public void givenAreNewLineSeparatedNumbersThenSumIsReturned() {
        assertThat(subject.add("1\n2"), is(3));
    }

    @Test
    public void givenAreNewLineAndCommaSeparatedNumbersThenSumIsReturned() {
        assertThat(subject.add("1\n2,3,10"), is(16));
    }

    @Test
    public void givenAreCommaSeparatedNumbersWithControlCharacterThenSumIsReturned() {
        assertThat(subject.add("//,\n2,3,10"), is(15));
    }

    @Test
    public void givenAreSemicolonSeparatedNumbersWithControlCharacterThenSumIsReturned() {
        assertThat(subject.add("//;\n2;3;10"), is(15));
    }

    @Test
    public void givenIsNegativeNumberThenExceptionIsReturned() {
        try {
            subject.add("-11");
            fail("Exception expected");
        } catch (Exception e) {
            assertThat(e.getMessage(), containsString("negatives not allowed"));
        }
    }

    @Test
    public void givenAreNegativeNumbersThenExceptionIsReturnedWithNegatives() {
        try {
            subject.add("2,-11,-3,-4");
            fail("Exception expected");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("negatives not allowed: -11,-3,-4"));
        }
    }


}

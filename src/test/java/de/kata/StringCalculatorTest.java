package de.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
}

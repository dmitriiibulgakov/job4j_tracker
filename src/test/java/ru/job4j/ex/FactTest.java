package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcShouldThrowIllegalArgumentException() {
        new Fact().calc(-1);
    }

    @Test
    public void calcShouldReturn24() {
        int expected = 24;
        int actual = new Fact().calc(4);
        assertThat(actual, is(expected));
    }
}

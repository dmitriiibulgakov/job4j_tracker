package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenMatrix3By3Then9Elements() {
        Integer[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix matrix = new Matrix();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> actual = matrix.toList(data);
        assertThat(expected, is(actual));
    }

    @Test
    public void whenMatrixWith2LInesThen5Elements() {
        Integer[][] data = {{1, 2}, {4, 5, 9}};
        Matrix matrix = new Matrix();
        List<Integer> expected = List.of(1, 2, 4, 5, 9);
        List<Integer> actual = matrix.toList(data);
        assertThat(expected, is(actual));
    }
}
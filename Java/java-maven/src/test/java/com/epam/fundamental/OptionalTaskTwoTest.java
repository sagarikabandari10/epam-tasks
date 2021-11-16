package com.epam.fundamental;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class OptionalTaskTwoTest {

    @Test
    void createMatrix() {
        //setup
        int rows = 5, columns = 10, bound = 10;
        int[][] actual = OptionalTaskTwo.createMatrix(rows, columns, bound);
        Assert.assertEquals(rows, actual.length);
        Assert.assertEquals(columns, actual[0].length);
    }

    @Test
    void getMaxValue() {
        int expected = 6;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, expected},};

        int actual = OptionalTaskTwo.getMaxValue(matrix);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void replaceValue() {
        int[][] matrix = {{5, 2, 3}, {4, 5, 6}};
        int[][] expected = {{8, 2, 3}, {4, 8, 6}};
        int oldValue = 5;
        int newValue = 8;
        int[][] actual = OptionalTaskTwo.replaceValue(matrix, oldValue, newValue);

        assertArrayEquals(expected, actual);
        Assert.assertEquals(8, actual[0][0]);
        Assert.assertEquals(8, actual[1][1]);
    }
}
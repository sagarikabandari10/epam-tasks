package com.epam.javafundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class optionalTask2Test {

    @Test
    void createMatrix() {
        //setup
        int rows=5,columns=10,bound=10;
       int[][] actual = OptionalTask2.createMatrix(rows,columns,bound);
       assertEquals(rows, actual.length);
       assertEquals(columns, actual[0].length);
    }

    @Test
    void getMaxValue() {
        int expected = 6;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, expected},};

        int actual = OptionalTask2.getMaxValue(matrix);

        assertEquals(expected,actual);
    }

    @Test
    void replaceValue() {
        int[][] matrix = { {5, 2, 3},{4, 5, 6}};
        int[][] expected = { {8, 2, 3},{4, 8, 6}};
        int oldValue = 5;
        int newValue = 8;
        int[][] actual = OptionalTask2.replaceValue(matrix,oldValue,newValue);

        assertArrayEquals(expected,actual);
        assertEquals(8,actual[0][0]);
        assertEquals(8,actual[1][1]);
    }
}
package com.epam.fundamental;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTaskTest {

    @org.junit.jupiter.api.Test
    void greetingUser() {
        String value = "TestSagarika";
        String expected = "Welcome " + value;
        String actual = MainTask.greetingUser(value);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void reverse() {
        String[] value = {"Test", "Demo", "hello", "print"};
        String expected = "tnirp olleh omeD tseT";
        String actual = MainTask.reverse(value);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void randomNumbers() {
        int value = 2;
        int[] actual = MainTask.randomNumbers(value);

        for (int i : actual) {
            assertTrue(i < 10);
        }
    }

    @org.junit.jupiter.api.Test
    void SumOfNumbers() {
        String[] value = new String[]{"Test", "10", "Demo", "5"};
        int expected = 15;
        int actual = MainTask.sumOfNumbers(value);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void tryParse() {
        String value = "10";
        int expected = 10;
        int actual = MainTask.tryParse(value);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void tryParse_invalidParameter() {
        String value = "Test";
        int expected = -1;
        int actual = MainTask.tryParse(value);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getMonthName() {
        int value = 7;
        String expected = "July";
        String actual = MainTask.getMonthName(value);

        assertEquals(expected, actual);
    }
}
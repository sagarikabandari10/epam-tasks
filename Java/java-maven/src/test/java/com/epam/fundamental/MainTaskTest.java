package com.epam.fundamental;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTaskTest {

    @Test
    void greetingUser() {
        String value = "TestSagarika";
        String expected = "Welcome " + value;
        String actual = MainTask.greetingUser(value);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void reverse() {
        String[] value = {"Test", "Demo", "hello", "print"};
        String expected = "tnirp olleh omeD tseT";
        String actual = MainTask.reverse(value);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void randomNumbers() {
        int value = 2;
        int[] actual = MainTask.randomNumbers(value);

        for (int i : actual) {
            Assert.assertTrue(i < 10);
        }
    }

    @Test
    void SumOfNumbers() {
        String[] value = new String[]{"Test", "10", "Demo", "5"};
        int expected = 15;
        int actual = MainTask.sumOfNumbers(value);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void tryParse() {
        String value = "10";
        int expected = 10;
        int actual = MainTask.tryParse(value);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void tryParse_invalidParameter() {
        String value = "Test";
        int expected = -1;
        int actual = MainTask.tryParse(value);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getMonthName() {
        int value = 7;
        String expected = "July";
        String actual = MainTask.getMonthName(value);

        Assert.assertEquals(expected, actual);
    }
}
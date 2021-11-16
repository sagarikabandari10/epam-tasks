package com.epam.fundamental;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OptionalTaskTest {

    @Test
    void checkEvenCode() {
        String value = "Sag";
        boolean actual = OptionalTask.checkEvenCode(value);
        Assert.assertTrue(actual);
    }

    @Test
    void checkEvenCode_invalidParameter() {
        String value = "sag";
        boolean actual = OptionalTask.checkEvenCode(value);
        Assert.assertFalse(actual);
    }

    @Test
    void checkDistinctDigits() {
        int value = 256;
        boolean actual = OptionalTask.checkDistinctDigits(value);
        Assert.assertTrue(actual);
    }

    @Test
    void checkDistinctDigits_InvalidParameter() {
        int value = 121;
        boolean actual = OptionalTask.checkDistinctDigits(value);
        Assert.assertFalse(actual);
    }
}
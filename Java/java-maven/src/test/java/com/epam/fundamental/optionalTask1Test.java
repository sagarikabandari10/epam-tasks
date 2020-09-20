package com.epam.fundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class optionalTask1Test {

    @Test
    void checkEvenCode() {
        String value = "Sag";
        boolean actual = OptionalTask1.checkEvenCode(value);
        assertTrue(actual);
    }

    @Test
    void checkEvenCode_invalidParameter() {
        String value = "sag";
        boolean actual = OptionalTask1.checkEvenCode(value);
        assertFalse(actual);
    }

    @Test
    void checkDistinctDigits() {
        int value = 256;
        boolean actual = OptionalTask1.checkDistinctDigits(value);
        assertTrue(actual);
    }

    @Test
    void checkDistinctDigits_InvalidParameter() {
        int value = 121;
        boolean actual = OptionalTask1.checkDistinctDigits(value);
        assertFalse(actual);
    }
}
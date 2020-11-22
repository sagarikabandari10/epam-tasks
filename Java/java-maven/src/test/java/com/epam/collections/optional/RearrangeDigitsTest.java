package com.epam.collections.optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeDigitsTest {

    @Test
    void swapDigitsWithoutTemp() {
        int[] actual = {-1, 2, -3, -4, 4, 9};
        RearrangeDigits.swapDigitsWithoutTemp(actual);
        int[] expected = {2, 4, 9,-4, -1, -3};
        assertArrayEquals(expected, actual);

    }
}
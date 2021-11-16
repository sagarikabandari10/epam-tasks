package com.epam.collections.optional;

import org.testng.Assert;
import org.testng.annotations.Test;

class RearrangeDigitsTest {

    @Test
    void swapDigitsWithoutTemp() {
        int[] actual = {-1, 2, -3, -4, 4, 9};
        RearrangeDigits.swapDigitsWithoutTemp(actual);
        int[] expected = {2, 4, 9,-4, -1, -3};
        Assert.assertEquals(expected, actual);
    }
}
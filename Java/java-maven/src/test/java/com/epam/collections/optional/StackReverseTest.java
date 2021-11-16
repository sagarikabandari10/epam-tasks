package com.epam.collections.optional;



import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

class StackReverseTest {

    @Test
    void reverse() {
        Stack<Integer> digits = new Stack<>();
        digits.push(8);
        digits.push(10);
        digits.push(5);
        List<Integer> actual = StackReverse.reverse(digits);
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(10);
        expected.add(8);
        Assert.assertEquals(expected, actual);
    }
}
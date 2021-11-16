package com.epam.collections.optional;

import org.testng.Assert;
import org.testng.annotations.Test;

class FileReadWriteTest {

    @Test
    void getReverseString() {
        String string = "Ravi";
        String actual = FileReadWrite.getReverseString(string);
        Assert.assertEquals("ivaR", actual);
    }

    @Test
    void getReverseStringWithNumbers() {
        String string = "1234";
        String actual = FileReadWrite.getReverseString(string);
        Assert.assertEquals("4321", actual);
    }
}
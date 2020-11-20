package com.epam.collections.optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReadWriteTest {

    @Test
    void getReverseString() {
        String string = "Ravi";
        String actual = FileReadWrite.getReverseString(string);
        assertEquals("ivaR", actual);
    }

    @Test
    void getReverseStringWithNumbers() {
        String string = "1234";
        String actual = FileReadWrite.getReverseString(string);
        assertEquals("4321", actual);
    }
}
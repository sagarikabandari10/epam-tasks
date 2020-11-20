package com.epam.collections.optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketPlacementTest {

    @Test
    void hasCorrectBracketsValidPosition() {
        String brackets = "{()}";
        assertTrue(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsInValidPosition() {
        String brackets = "{(}";
        assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsStartWithClose() {
        String brackets = "}{";
        assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsIsEmpty() {
        String brackets = "";
        assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsWithCharater() {
        String brackets = "AB1234!@#";
        assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }
}
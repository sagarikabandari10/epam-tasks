package com.epam.collections.optional;

import org.testng.Assert;
import org.testng.annotations.Test;

class BracketPlacementTest {

    @Test
    void hasCorrectBracketsValidPosition() {
        String brackets = "{()}";
        Assert.assertTrue(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsInValidPosition() {
        String brackets = "{(}";
        Assert.assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsStartWithClose() {
        String brackets = "}{";
        Assert.assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsIsEmpty() {
        String brackets = "";
        Assert.assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }

    @Test
    void hasCorrectBracketsWithCharater() {
        String brackets = "AB1234!@#";
        Assert.assertFalse(BracketPlacement.hasCorrectBrackets(brackets));
    }
}
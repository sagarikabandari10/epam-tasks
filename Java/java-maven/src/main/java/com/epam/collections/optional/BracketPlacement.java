package com.epam.collections.optional;

import java.util.Stack;

public class BracketPlacement {
    public static void main(String[] args) {
        String brackets = "{()}";
        if (isPlacementCorrect(brackets)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    public static boolean isPlacementCorrect(String brackets) {
        if (brackets.length() == 0) {
            return false;
        }
        char[] chars = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c == ')' || c == ']' || c == '}') {
                stack.pop();
            }
        }
        return (stack.isEmpty());
    }
}

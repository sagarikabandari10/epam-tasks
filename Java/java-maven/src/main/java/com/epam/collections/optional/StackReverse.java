package com.epam.collections.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackReverse {
    public static void main(String[] args) {
        Stack<Integer> digits = setDefaultValuesForStack();
        System.out.println("Before Reverse: "+ digits);
        List<Integer> list = reverse(digits);
        System.out.println("After Reverse: "+list);
    }

    private static Stack<Integer> setDefaultValuesForStack() {
        Stack<Integer> digits = new Stack<>();
        digits.push(10);
        digits.push(15);
        digits.push(3);
        digits.push(44);
        return digits;
    }

    public static List<Integer> reverse(Stack<Integer> digits) {
        List<Integer> list = new ArrayList<>();
        while(digits.size() > 0){
            list.add(digits.pop());
        }
        return list;
    }
}

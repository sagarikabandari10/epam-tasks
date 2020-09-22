package com.epam.collections.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackReverse {
    private static final Stack<Integer> digits = new Stack<>();
    private static List<Integer> list = new ArrayList<>();

    private static void setDefaultValuesForStack() {
        digits.push(10);
        digits.push(15);
        digits.push(3);
        digits.push(44);
    }

    private static void Reverse() {
        while(digits.size()>0){
            list.add(digits.pop());
        }
    }

    public static void main(String[] args) {
        setDefaultValuesForStack();
        System.out.println("Before Reverse: "+ digits);
        Reverse();
        System.out.println("After Reverse: "+list);
    }
}

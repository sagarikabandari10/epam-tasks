package com.epam.collections.optional;

import java.util.Stack;

public class BracketPlacement {

    public static boolean IsPlacementCorrect(String st){
        if(st.length()==0) return false;
        char[] chars = st.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char c:chars) {
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) return false;
            switch (c){
                case ')':
                case ']':
                case '}':
                    stack.pop();

            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String expr = "()";//format should always starts with open then close brackets.
        if (IsPlacementCorrect(expr))//returns boolean.
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}

package com.epam.collections.optional;

import java.util.Arrays;
import java.util.List;

public class PoemLineSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Rain Rain"
                , "Go away"
                , "Come again"
                , "Little Babullo"
                , "Wants to play");
        list.sort((s1, s2) -> s1.length() - s2.length());
        list.forEach(s -> System.out.println(s + "-" + s.length()));
    }
}


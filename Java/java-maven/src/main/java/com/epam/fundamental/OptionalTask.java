package com.epam.fundamental;

import java.util.Arrays;

public class OptionalTask {

    public static void main(String[] args) {
        System.out.println("Java Fundamentals Optional Task 1 Programs.\n");

        int[] ints = new int[]{50, 55, 87, 90, 95, 100, 125, 144, 1, 8, 10, 43};

        System.out.println("Array = " + Arrays.toString(ints));
        System.out.println("Array length = " + ints.length);
        Arrays.sort(ints);
        System.out.println("Sorted Array = " + Arrays.toString(ints));
        System.out.println("Shortest number = " + ints[0]);
        System.out.println("Longest number = " + ints[ints.length - 1]);
        System.out.println();

        String[] strings = new String[]{"let", "always", "willbe", "sun", "moon", "stars"};
        Arrays.sort(strings, (a, b) -> a.length() - b.length());
        System.out.println("Sorted Array ascending order by lengths = " + Arrays.toString(strings));
        Arrays.sort(strings, (a, b) -> b.length() - a.length());
        System.out.println("Sorted Array descending order by lengths = " + Arrays.toString(strings));

        System.out.println();
        int sum = 0, avg;
        for (String i : strings) {
            sum += i.length();
        }
        avg = sum / strings.length;
        System.out.println("Array Sum = " + sum);
        System.out.println("Array avg = " + avg);
        System.out.println("Array length = " + strings.length);
        System.out.println("Print array avg > values : ");
        for (String i : strings) {
            if (i.length() > avg) {
                System.out.print(i + "-" + i.length() + " ");
            }
        }

        System.out.println("\n\nFind a word with characters in strict ascending order of their codes");
        strings = new String[]{"Ravi", "Sag", "Pra", "Raiv"};
        System.out.println(Arrays.asList(strings));
        for (String str : strings) {
            if (checkEvenCode(str)) {
                System.out.println("Asc order: " + str);
                break;
            }
        }

        System.out.println("\nThe first number consisting of only distinct digits");
        ints = new int[]{22, 323, 1231, 123, 456, 3443};
        System.out.println(Arrays.toString(ints));
        for (int in : ints) {
            if (checkDistinctDigits(in)) {
                System.out.println("Distinct Number: " + in);
                break;
            }
        }

    }

    public static boolean checkEvenCode(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if ((int) chars[i] > (int) chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDistinctDigits(int numbers) {
        int[] digits = Integer.toString(numbers).chars().toArray();
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
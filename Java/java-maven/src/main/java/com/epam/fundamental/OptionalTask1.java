package com.epam.fundamental;
import java.util.*;
public class OptionalTask1 {

    public static boolean checkEvenCode(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //System.out.println(chars[i]+"-"+(int)chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if ((int) chars[i] > (int) chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDistinctDigits(int in) {

        int[] digits = Integer.toString(in).chars().toArray();//Int - String - chars - array.
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Java Fundamentals Optional Task 1 Programs.\n");

        //1. Find the shortest and longest number. Print the found numbers and their length.

        int[] ints = new int[]{50, 55, 87, 90, 95, 100, 125, 144, 1, 8, 10, 43};
        /*System.out.println(Arrays.stream(ints).max());
        System.out.println(Arrays.stream(ints).min());*/
        System.out.println("Array = " + Arrays.toString(ints));
        System.out.println("Array length = " + ints.length);
        Arrays.sort(ints);
        System.out.println("Sorted Array = " + Arrays.toString(ints));
        System.out.println("Shortest number = " + ints[0]);
        System.out.println("Longest number = " + ints[ints.length - 1]);
        System.out.println("");
        /* output:
        Array = [50, 55, 87, 90, 95, 100, 125, 144, 1, 8, 10, 43]
        Array length = 12
        Sorted Array = [1, 8, 10, 43, 50, 55, 87, 90, 95, 100, 125, 144]
        Shortest number = 1
        Longest number = 144*/

        //2. Arrange and print strings in ascending (descending) order of their lengths

        String[] strings = new String[]{"let", "always", "willbe", "sun", "moon","stars"};
        Arrays.sort(strings, (a, b) -> a.length() - b.length());
        System.out.println("Sorted Array ascending order by lengths = " + Arrays.toString(strings));
        Arrays.sort(strings, (a, b) -> b.length() - a.length());
        System.out.println("Sorted Array descending order by lengths = " + Arrays.toString(strings));
       /* output:
       Sorted Array ascending order by lengths = [Let, sun, bat, always, willbe]
        Sorted Array descending order by lengths = [always, willbe, Let, sun, bat]*/

        //3. Print to the console those numbers whose length is less (more) than the average length for all numbers , as well as the length.
        System.out.println();
        int sum=0, avg;
        for (String i : strings) {
            sum += i.length();//3+6+6+3+4+5
        }
        avg = sum / strings.length;
        System.out.println("Array Sum = " + sum);
        System.out.println("Array avg = " + avg);
        System.out.println("Array length = " + strings.length);
        System.out.println("Print array avg > values : ");
        for (String i : strings) {
            if (i.length() > avg)
                System.out.print(i + "-" + i.length() + " ");
        }
//       output: always-6 willbe-6 stars-5

        //6 .Find a number with digits in strict ascending order. If there are several such numbers, find the first one.

        System.out.println("\n\nFind a word with characters in strict ascending order of their codes");
        strings = new String[]{"Ravi", "Sag", "Pra", "Raiv"};
        System.out.println(Arrays.asList(strings));
        for (String str:strings) {
            if(checkEvenCode(str)){
                System.out.println("Asc order: "+str);
                break;
            }
        }
        /*output: [Ravi, Sag, Pra]
         Asc order: Sag*/

        //7. Find a number consisting only of different digits. If there are several such numbers, find the first one.

        System.out.println("\nThe first number consisting of only distinct digits");
        ints = new int[]{22, 323, 1231, 123, 456,3443};
        System.out.println(Arrays.toString(ints));
        for (int in:ints) {
            if(checkDistinctDigits(in)){
                System.out.println("Distinct Number: "+in);
                break;
            }
        }
        /*output: [22, 323, 1231, 123, 456, 3443]
        Distinct Number: 123*/
    }
}
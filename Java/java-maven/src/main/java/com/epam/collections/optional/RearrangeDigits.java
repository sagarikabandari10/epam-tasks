package com.epam.collections.optional;

public class RearrangeDigits {
    public static void main(String[] args) {
        int[] array = {-1, 2, -3, -4, 4, 5, 6, -7, 8, 9};
        System.out.println("Before Swap: ");
        printArray(array);
        rearrange(array);
        System.out.println("\nAfter Swap: ");
        printArray(array);
    }

    public static void rearrange(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (i != j) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
                j++;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

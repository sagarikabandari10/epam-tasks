package com.epam.collections.optional;

public class RearrangeDigits {

    public static void Rearrange(int[] array){
        int j=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (i != j) {
                    array[i] = array[i] + array[j];// add i & j array values & override array i.
                    array[j] = array[i] - array[j];// sub i & j array values & override array j.
                    array[i] = array[i] - array[j];// sub i & j array values & override array i.
                }
                j++;//After filling j position with +ve no, increment to next position
            }
        }
    }

    public static void PrintArray(int[] array){
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = { -1, 2, -3, -4, 4, 5, 6, -7, 8, 9 }; // create & initialize int array.
        System.out.println("Before Swap: ");
        PrintArray(array);
        Rearrange(array);
        System.out.println("\nAfter Swap: ");
        PrintArray(array);
    }
}

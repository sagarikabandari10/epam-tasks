package com.epam.fundamental;

import java.util.Random;

public class OptionalTaskTwo {
    public static void main(String[] args) {
        int rows = 3, columns = 3, bound = 20, col = 2, newValue = 0;
        int[][] matrix = createMatrix(rows, columns, bound);
        printMatrix(matrix);

        int maxValue = getMaxValue(matrix);
        System.out.println("Max value from array: " + maxValue);
        System.out.println(String.format("Replace %s with %s", maxValue, newValue));
        replaceValue(matrix, maxValue, newValue);
        printMatrix(matrix);

        System.out.println("Sort Matrix based on column: " + col);
        sortColumn(matrix, col - 1);
        printMatrix(matrix);

    }

    public static int[][] createMatrix(int rows, int columns, int bound) {
        int[][] mat = new int[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = rand.nextInt(bound);
            }
        }
        return mat;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static int getMaxValue(int[][] numbers) {
        int maxValue = numbers[0][0];
        for (int[] number : numbers) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (number[j] > maxValue) {
                    maxValue = number[j];
                }
            }
        }
        return maxValue;
    }

    public static void sortColumn(int[][] array, int e) {
        for (int i = 0; i < array.length; i++)
            for (int k = i + 1; k < array[0].length; k++) {
                if (array[i][e] > array[k][e]) {
                    for (int j = 0; j < array[0].length; j++) {
                        int temp = array[i][j];
                        array[i][j] = array[k][j];
                        array[k][j] = temp;
                    }
                }
            }
    }

    public static int[][] replaceValue(int[][] numbers, int value, int newValue) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == value) {
                    numbers[i][j] = newValue;
                }
            }
        }
        return numbers;
    }
}

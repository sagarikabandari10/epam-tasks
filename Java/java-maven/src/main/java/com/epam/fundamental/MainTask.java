package com.epam.fundamental;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {
        System.out.println("Java Fundamentals Main Programs.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println(greetingUser(name));
        System.out.println();

        System.out.println(reverse(args));

        System.out.println("\nPrint random numbers");
        int[] res = randomNumbers(5);
        for (int i : res) {
            System.out.print(i + " ");
        }

        int sum = sumOfNumbers(args);
        System.out.println("\n\nSum of numbers: " + sum);

        int monthNumber;
        System.out.print("\nEnter month's number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter valid number: ");
            scanner.next();
        }
        monthNumber = scanner.nextInt();

        System.out.println("\nPrint month for: " + monthNumber);
        String MonthOfName = getMonthName(monthNumber);
        System.out.println("Month Name: " + MonthOfName);

    }

    public static String greetingUser(String name) {
        return String.format("Welcome %s", name);
    }
    public static String reverse(String[] args) {
        StringBuilder stringReverse = new StringBuilder();
        if (args.length == 0) {
            args = new String[]{"Sag", "Ravi"};
        }
        System.out.println(Arrays.asList(args));
        for (int i = args.length - 1; i >= 0; i--) {
            for (int j = args[i].length() - 1; j >= 0; j--) {
                stringReverse.append(args[i].charAt(j));
            }
            stringReverse.append(" ");

        }
        return stringReverse.toString().trim();
    }

    public static int[] randomNumbers(int count) {
        Random random = new Random();
        int[] randomList = new int[count];
        for (int i = 0; i < count; i++) {
            randomList[i] = random.nextInt(10);
        }
        return randomList;
    }

    public static String getMonthName(int monthNumber) {
        String MonthOfName;
        switch (monthNumber) {
            case 1:
                MonthOfName = "January";
                break;
            case 2:
                MonthOfName = "February";
                break;
            case 3:
                MonthOfName = "March";
                break;
            case 4:
                MonthOfName = "April";
                break;
            case 5:
                MonthOfName = "May";
                break;
            case 6:
                MonthOfName = "June";
                break;
            case 7:
                MonthOfName = "July";
                break;
            case 8:
                MonthOfName = "August";
                break;
            case 9:
                MonthOfName = "September";
                break;
            case 10:
                MonthOfName = "October";
                break;
            case 11:
                MonthOfName = "November";
                break;
            case 12:
                MonthOfName = "December";
                break;
            default:
                MonthOfName = "Invalid month";
                break;
        }
        return MonthOfName;
    }

    public static int sumOfNumbers(String[] args) {
        int sum = 0;
        for (String s : args) {
            int value = tryParse(s);
            if (value > 0) {
                sum += value;
            }
        }
        return sum;
    }

    public static int tryParse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}

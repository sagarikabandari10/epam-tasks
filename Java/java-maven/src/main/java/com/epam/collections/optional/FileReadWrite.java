package com.epam.collections.optional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {
    public static void main(String[] args) {
        try {
            File file = CheckFileExists();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            List<String> list = new ArrayList<>();
            System.out.println("\nBefore Reverse:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                list.add(getStringReverse(line) + "\n");
            }
            System.out.println("\nAfter Reverse:");
            System.out.println(list.toString());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringReverse(String line) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(line);
        return stringBuffer.reverse().toString();
    }

    private static File CheckFileExists() throws IOException {
        File file = new File("src/main/resources/Sample.txt");
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
        return file;
    }

}

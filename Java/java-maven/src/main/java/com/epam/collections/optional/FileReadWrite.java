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
            File file = getFileByPathName("src/main/resources/Sample.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            List<String> list = new ArrayList<>();
            System.out.println("\nBefore Reverse:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                list.add(getReverseString(line) + "\n");
            }
            System.out.println("\nAfter Reverse:");
            System.out.println(list.toString());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getReverseString(String line) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(line);
        return stringBuffer.reverse().toString();
    }

    private static File getFileByPathName(String pathName) throws IOException {
        File file = new File(pathName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
        return file;
    }

}

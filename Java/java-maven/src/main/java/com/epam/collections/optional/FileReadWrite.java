package com.epam.collections.optional;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {

    private static String getStringReverse(String str) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(str);
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

    public static void main(String[] args) {
        try {
            File file = CheckFileExists();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;
            List<String> list = new ArrayList<>();
            System.out.println("\nBefore Reverse:");
            while ((str = bufferedReader.readLine()) != null) {//reads line by line & checks for nulls & assign to st variable.if condition true enters loop
                System.out.println(str); //print st(variable name)
                list.add(getStringReverse(str) + "\n");//add to StringBuffer.
            }
            System.out.println("\nAfter Reverse:");
            System.out.println(list.toString());//print StringBuffer bufferedReader sequence order(toString())
            bufferedReader.close();
        } catch (IOException e) {//check for Input\output exe.(file read\write )
            e.printStackTrace();
        }
    }
}

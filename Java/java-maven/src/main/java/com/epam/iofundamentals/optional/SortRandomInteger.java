package com.epam.iofundamentals.optional;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SortRandomInteger {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src", "main", "java", "com", "epam", "iofundamentals", "data", "RandomNumbers.txt");
        Random random = new Random();
        StringBuilder content = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            int x = random.nextInt(10);
            content.append(x);
        }

        File file = new File(String.valueOf(path));
        if(file.createNewFile()) {
            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.flush();
            writer.close();
            FileReader reader = new FileReader(file);
            int data;
            List<Character> list = new ArrayList<>();
            while ((data = reader.read()) != -1) {
                list.add((char) data);
            }
            Collections.sort(list);
            System.out.println(list);
            reader.close();
        }
    }
}

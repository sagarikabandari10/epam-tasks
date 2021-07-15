package com.epam.iofundamentals.optional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordsUpperCase {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "main", "java", "com", "epam", "iofundamentals", "optional", "WordsUpperCase.java");
        File file = new File(String.valueOf(path));
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 2) {
                    System.out.println(word.toUpperCase());
                }
            }
        }
        reader.close();
        br.close();
    }
}

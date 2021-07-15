package com.epam.iofundamentals.optional;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReplaceWord {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "main", "java", "com", "epam", "iofundamentals", "optional", "ReplaceWord.java");
        FileReader reader = new FileReader(String.valueOf(path));
        BufferedReader br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String line;
        br.skip(150);
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        System.out.println(sb.toString().replace("public", "private"));
    }
}

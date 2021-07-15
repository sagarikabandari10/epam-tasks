package com.epam.iofundamentals.optional;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReverseOrder {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "main", "java", "com", "epam", "iofundamentals", "optional", "ReverseOrder.java");
        Path writePath = Paths.get("src", "main", "java", "com", "epam", "iofundamentals", "data", "ReverseOrder.txt");
        FileReader reader = new FileReader(String.valueOf(path));
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        br.close();
        File file = new File(writePath.toString());
        if(file.createNewFile()) {
            FileWriter writer = new FileWriter(file);
            writer.write(sb.reverse().toString());
            writer.close();
        }
    }
}

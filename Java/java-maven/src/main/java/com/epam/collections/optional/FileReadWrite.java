package com.epam.collections.optional;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {
    private static String fileName = "Sample.txt";
    public static void main(String[] args){
        try {
            File file = CheckFileExists();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;
            List<String> list = new ArrayList<>();
            System.out.println("\nBefore Reverse:");
            while((str = bufferedReader.readLine())!=null) {//reads line by line & checks for nulls & assign to st variable.if condition true enters loop
                System.out.println(str); //print st(variable name)
                list.add(getStringReverse(str) +"\n");//add to StringBuffer.
            }
            System.out.println("\nAfter Reverse:");
            //Collections.reverse(list);
            bufferedReader.close();
            System.out.println(list.toString());//print StringBuffer bufferedReader sequence order(toString())
           /* FileWriter myWriter = new FileWriter(file);//create FileWriter obj
            myWriter.write(list.toString());//writes StringBuffer(reverse) to file.
            myWriter.close();//close FileWriter obj.
            System.out.println("Successfully wrote to the file.");*/
        } catch (FileNotFoundException e) {//check for Input\output exe.(file read\write )
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringReverse(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.reverse().toString();
    }

    private static File CheckFileExists() throws IOException {
        File file = new File(getResourcesPath());
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
        return file;
    }

    private static String getResourcesPath() {
        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        Path filePath = Paths.get(root.toString(),"src", "main", "resources", fileName);
        return String.valueOf(filePath);
    }
}

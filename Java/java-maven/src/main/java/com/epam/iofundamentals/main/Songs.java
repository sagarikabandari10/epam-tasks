package com.epam.iofundamentals.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Songs {
    public static final String fileName = "English.txt";
    private static File file;
    private static final String rootPath = "C:";
    private static final String dirPath = rootPath + File.separator + "Amon Amarth";
    private static int dirCount = 0, fileCount = 0, fileLength = 0;
    private static final StringBuilder content = new StringBuilder();
    private static final List<String> subDirectories =
            Arrays.asList("2004 - Fate Of Norns", "2016 - Jomsviking", "2019 - Berserker");

    public static void main(String[] args) {
        try {
            if (args.length != 1) throw new IllegalArgumentException("Path was not set in program arguments.");
            String mainDir = args[0];
            createDirectories();
            getCounts(dirPath);
            WriteContentToFile(mainDir);

            System.out.printf("Number Of directories: %s\n", dirCount);
            System.out.printf("Number Of files: %s%n", fileCount);
            System.out.printf("Average number of files per directory: %s%n", fileCount / dirCount);
            System.out.printf("Average file name length: %s%n", fileLength / fileCount);
        } catch (IOException | ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void WriteContentToFile(String mainDir) throws IOException {
        createDirectory(mainDir);
        createFile(new StringBuilder().append(mainDir).append(File.separator).append(fileName).toString());
        FileWriter fw = new FileWriter(file);
        fw.write(content.toString());
        fw.close();
    }

    private static void createDirectories() throws IOException {
        createDirectory(dirPath);
        for (String subDirectory : subDirectories) {
            String subDirPath = dirPath + File.separator + subDirectory;
            createDirectory(subDirPath);
        }
    }

    private static void createDirectory(String dirPath) throws IOException {
        file = new File(dirPath);
        if (!file.exists() && !file.isDirectory() && !file.mkdir())
            throw new IOException("Error while creating directory.");

        content.append("\n").append(file.getName());
        createFiles(file.getName());
    }

    private static void createFiles(String directoryName) throws IOException {
        List<String> files = getFiles(directoryName);
        if (!files.isEmpty()) {
            String subDirPath = dirPath + File.separator + directoryName;
            for (String f : files) {
                String filePath = subDirPath + File.separator + f;
                createFile(filePath);
            }
        }
    }

    private static void createFile(String filePath) throws IOException {
        file = new File(filePath);
        if (!file.exists() && !file.isFile() && !file.createNewFile())
            throw new IOException("Error while creating file.");
        content.append("\n\t").append(file.getName());
    }


    private static List<String> getFiles(String subDirectory) {
        List<String> files = new ArrayList<>();
        switch (subDirectory) {
            case "2004 - Fate Of Norns":
                files = Arrays.asList("01 - An Ancient Sign Of Coming Storm.mp3",
                        "02 - Where Death Seems To Dwell.mp3",
                        "03 - The Fate Of Norns.mp3",
                        "04 - The Pursuit Of Vikings.mp3",
                        "05 - Valkyries Ride.mp3",
                        "06 - The Beheading Of A King.mp3",
                        "07 - Arson.mp3",
                        "08 - Once Sealed In Blood.mp3");
                break;
            case "2016 - Jomsviking":
                files = Arrays.asList(" 01 First Kill.mp3",
                        "02 Wanderer.mp3",
                        "03 On A Sea Of Blood.mp3",
                        "04 One Against All.mp3",
                        "05 Raise Your Horns.mp3",
                        "06 The Way Of Vikings.mp3",
                        "07 At Dawn’s First Light.mp3",
                        "08 One Thousand Burning Arrows.mp3",
                        "09 Vengeance Is My Name.mp3",
                        "10 A Dream That Cannot Be (feat. Doro Pesch).mp3",
                        "11 Back On Northern Shores.mp3",
                        "12 Death In Fire 2016.mp3",
                        "13 Death In Fire (Live).mp3");
                break;
            case "2019 - Berserker":
                files = Arrays.asList("01 Fafner's Gold.mp3",
                        "02 Crack the Sky.mp3",
                        "03 Mjölner, Hammer of Thor.mp3",
                        "04 Shield Wall.mp3",
                        "05 Valkyria.mp3",
                        "06 Raven's Flight.mp3",
                        "07 Ironside.mp3",
                        "08 The Berserker at Stamford Bridge.mp3",
                        "09 When Once Again We Can Set Our Sails.mp3",
                        "10 Skoll and Hati.mp3",
                        "11 Wings of Eagles.mp3",
                        "12 Into the Dark.mp3");
                break;
            default:
                //throw new IllegalStateException("Unexpected value: " + subDirectory);
        }
        return files;
    }

    private static void getCounts(String path) {
        file = new File(path);
        for (File list : Objects.requireNonNull(file.listFiles()))
            if (list.isDirectory()) {
                dirCount++;
                getCounts(list.getPath());
            } else {
                fileCount++;
                fileLength += list.getName().length();
            }
    }

}
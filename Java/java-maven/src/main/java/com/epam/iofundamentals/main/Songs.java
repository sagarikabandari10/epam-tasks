package com.epam.iofundamentals.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Songs {
    private static File file;
    private static final String rootPath = "C:";
    private static final String dirPath = rootPath + File.separator + "Amon Amarth";
    private static int dirCount = 0, fileCount = 0, fileLength = 0;

   private static final List<String> subDirectories =
            Arrays.asList("2004 - Fate Of Norns", "2016 - Jomsviking", "2019 - Berserker");

    public static void main(String[] args) {
        try {
            createDirectories();
            createFiles();

            getCounts(dirPath);

            System.out.printf("Number Of directories: %s%n",dirCount);
            System.out.printf("Number Of files: %s%n",fileCount);
            System.out.printf("Average number of files per directory: %s%n",fileCount/dirCount);
            System.out.printf("Average file name length: %s%n",fileLength/fileCount);
        } catch (IOException | ArithmeticException e) {
            System.err.println(e.getMessage());
        }
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
    }

    private static void createFiles() throws IOException {
        for(String subDir:subDirectories){
         List<String> files = getFiles(subDir);
            String subDirPath = dirPath + File.separator + subDir;
            for(String f:files){
                String filePath = subDirPath + File.separator + f;
                createFile(filePath);
            }
        }
    }

    private static void createFile(String filePath) throws IOException {
        file = new File(filePath);
        if (!file.exists() && !file.isFile() && !file.createNewFile())
            throw new IOException("Error while creating file.");
    }

    private static List<String> getFiles(String subDirectory) {
        List<String> files;
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
                throw new IllegalStateException("Unexpected value: " + subDirectory);
        }
        return files;
    }

    private static void getCounts(String path) {
        file = new File(path);
        for(File list: Objects.requireNonNull(file.listFiles()))
        if (list.isDirectory()) {
            dirCount++;
            getCounts(list.getPath());
        } else {
            fileCount++;
            fileLength += list.getName().length();
        }
    }

}
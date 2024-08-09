package com.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

//Utility class for file operations
public class FileUtils {

    //Lists the contents of the specified directory, including file names, sizes, and last modified dates
    public static void listDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                System.out.printf("Name: %-30s Size: %10d bytes Last Modified: %s%n",
                        file.getName(),
                        file.length(),
                        file.lastModified());
            });
        } else {
            System.out.println("The directory is empty or an error occurred.");
        }
    }

    //Copies a file from source to destination
    public static void copyFile(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    //Moves a file from source to destination
    public static void moveFile(File source, File destination) throws IOException {
        Files.move(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    //Deletes a file
    public static void deleteFile(File file) throws IOException {
        Files.delete(file.toPath());
    }

    //Creates a directory
    public static void createDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            Files.createDirectory(dir.toPath());
        } else {
            System.out.println("Directory already exists.");
        }
    }

    //Deletes a directory and its contents
    public static void deleteDirectory(File dir) throws IOException {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    Files.delete(file.toPath());
                }
            }
            Files.delete(dir.toPath());
        }
    }

    //Searches for files within a directory that contain the specified search term
    public static void searchFiles(File dir, String searchTerm) {
        File[] files = dir.listFiles((d, name) -> name.contains(searchTerm));
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files found.");
        }
    }
}

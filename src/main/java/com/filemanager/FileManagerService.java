package com.filemanager;

import java.io.File;
import java.io.IOException;

//Service class for file management operations
public class FileManagerService {

    //Displays the contents of a directory
    public void displayDirectoryContents(File dir) {
        try {
            FileUtils.listDirectoryContents(dir);
        } catch (Exception e) {
            FileManagerLogger.log("Error displaying directory contents: " + e.getMessage());
        }
    }

    //Copies a file from source to destination
    public void copyFile(File source, File destination) {
        try {
            FileUtils.copyFile(source, destination);
            FileManagerLogger.log("Copied file from " + source.getAbsolutePath() + " to " + destination.getAbsolutePath());
        } catch (IOException e) {
            FileManagerLogger.log("Error copying file: " + e.getMessage());
        }
    }

    //Moves a file from source to destination
    public void moveFile(File source, File destination) {
        try {
            FileUtils.moveFile(source, destination);
            FileManagerLogger.log("Moved file from " + source.getAbsolutePath() + " to " + destination.getAbsolutePath());
        } catch (IOException e) {
            FileManagerLogger.log("Error moving file: " + e.getMessage());
        }
    }

    //Deletes a file
    public void deleteFile(File file) {
        try {
            FileUtils.deleteFile(file);
            FileManagerLogger.log("Deleted file: " + file.getAbsolutePath());
        } catch (IOException e) {
            FileManagerLogger.log("Error deleting file: " + e.getMessage());
        }
    }

    //Creates a directory
    public void createDirectory(File dir) {
        try {
            FileUtils.createDirectory(dir);
            FileManagerLogger.log("Created directory: " + dir.getAbsolutePath());
        } catch (IOException e) {
            FileManagerLogger.log("Error creating directory: " + e.getMessage());
        }
    }

    //Deletes a directory and its contents
    public void deleteDirectory(File dir) {
        try {
            FileUtils.deleteDirectory(dir);
            FileManagerLogger.log("Deleted directory: " + dir.getAbsolutePath());
        } catch (IOException e) {
            FileManagerLogger.log("Error deleting directory: " + e.getMessage());
        }
    }

    //Searches for files in a directory that contain the specified search term
    public void searchFiles(File dir, String searchTerm) {
        FileUtils.searchFiles(dir, searchTerm);
    }
}

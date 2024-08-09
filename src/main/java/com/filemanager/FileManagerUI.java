package com.filemanager;

import java.io.File;
import java.util.Scanner;

//User Interface for the File Manager application
public class FileManagerUI {

    private static final Scanner scanner = new Scanner(System.in);
    private final FileManagerService service = new FileManagerService();

    //Starts the user interface, displaying a menu and processing user input
    public void start() {
        while (true) {
            System.out.println("\nFile Manager Application");
            System.out.println("1. List directory contents");
            System.out.println("2. Copy file");
            System.out.println("3. Move file");
            System.out.println("4. Delete file");
            System.out.println("5. Create directory");
            System.out.println("6. Delete directory");
            System.out.println("7. Search files");
            System.out.println("8. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); //Reads the user's input

            switch (option) {
                case 1:
                    listDirectoryContents();
                    break;
                case 2:
                    copyFile();
                    break;
                case 3:
                    moveFile();
                    break;
                case 4:
                    deleteFile();
                    break;
                case 5:
                    createDirectory();
                    break;
                case 6:
                    deleteDirectory();
                    break;
                case 7:
                    searchFiles();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //Prompts the user for a directory path and lists its contents
    private void listDirectoryContents() {
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        File dir = new File(path);
        service.displayDirectoryContents(dir);
    }

    //Prompts the user for source and destination file paths and copies the file
    private void copyFile() {
        System.out.print("Enter source file path: ");
        String srcPath = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destPath = scanner.nextLine();
        File source = new File(srcPath);
        File destination = new File(destPath);
        service.copyFile(source, destination);
    }

    //Prompts the user for source and destination file paths and moves the file
    private void moveFile() {
        System.out.print("Enter source file path: ");
        String srcPath = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destPath = scanner.nextLine();
        File source = new File(srcPath);
        File destination = new File(destPath);
        service.moveFile(source, destination);
    }

    //Prompts the user for a file path and deletes the file
    private void deleteFile() {
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();
        File file = new File(path);
        service.deleteFile(file);
    }

    //Prompts the user for a directory path and creates the directory
    private void createDirectory() {
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        File dir = new File(path);
        service.createDirectory(dir);
    }

    //Prompts the user for a directory path and deletes the directory
    private void deleteDirectory() {
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        File dir = new File(path);
        service.deleteDirectory(dir);
    }

    //Prompts the user for a directory path and a search term and then searches for files
    private void searchFiles() {
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();
        File dir = new File(dirPath);
        service.searchFiles(dir, searchTerm);
    }
}


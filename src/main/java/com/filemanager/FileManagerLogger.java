package com.filemanager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Logger for the File Manager application
public class FileManagerLogger {
    private static final String LOG_FILE = "file_manager.log";

    //Logs a message to the log file
    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            System.err.println("Failed to log message: " + e.getMessage());
        }
    }
}

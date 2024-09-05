package Task5Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    // Private constructor to prevent instantiation
    private Logger() {
        // Default log file name
        this.fileName = "default_log.txt";

        try {
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Public method to provide access to the singleton instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to write a log message to the file
    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush(); // Ensure the message is written to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to change the log file name
    public void setFileName(String fileName) {
        try {
            writer.close(); // Close the current file writer
            this.fileName = fileName;
            this.writer = new BufferedWriter(new FileWriter(fileName, true)); // Open a new file writer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to close the file writer
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


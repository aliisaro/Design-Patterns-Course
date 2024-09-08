package Task5Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance; // used for singleton pattern
    private BufferedWriter writer; // for file operations
    private String fileName;

    // constructor
    private Logger(){
        fileName = "defaultName.txt"; //initialize logger with default file name
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true)); // true for append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        if (instance == null) { //if there is no instance, create new instance
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String newFileName){
        try {
            if (writer != null) { //close current file if it's open
                writer.close();
            }
            fileName = newFileName;
            writer = new BufferedWriter(new FileWriter(fileName, true)); // Open new file in append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String message){
        try {
            writer.write(message);
            writer.newLine(); // Move to the next line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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


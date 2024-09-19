package Task6Decorator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends Printer{
    private Printer printer; //instance of printer
    private BufferedWriter writer; //for file operations

    public FilePrinter(Printer printer) { // Constructor that initializes the FilePrinter with a Printer instance
        this.printer = printer;
    }

    @Override
    public void print(String message){
        // if file exists already, it opens the file in append mode and writes the message to it
        try {
            writer = new BufferedWriter(new FileWriter("FILE-PRINTER.txt", true));
            writer.write(message);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Task6Decorator;

public class Main {
    public static void main(String[] args) {

        // Creates instance of a basic printer that prints the message to the console
        Printer printer = new BasicPrinter();
        printer.print("Hello World! This is printer 1");

        // Creates an instance of an encrypted printer that wraps a file printer that wraps a basic printer.
        Printer printer2 = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        printer2.print("Hello World! This is printer 2");

    }
}

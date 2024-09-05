package Task5Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.write("Simulation started");
        logger.setFileName("new_log.txt"); // Change file name
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close(); // Close the logger
    }
}

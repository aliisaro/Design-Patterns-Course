package Task14Builder;

public class Main {
    public static void main(String[] args) {

        // Create a gaming computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder(); // Gaming computer builder instance
        ComputerDirector director = new ComputerDirector(gamingBuilder); // Director instance with gamingBuilder
        Computer gamingComputer = director.constructComputer(); // Call constructComputer method
        System.out.println("Gaming Computer Config: " + gamingComputer); // Print the gaming computer configuration

        // Create an office computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder(); // Office computer builder instance
        director = new ComputerDirector(officeBuilder); // Director instance with officeBuilder
        Computer officeComputer = director.constructComputer(); // Call constructComputer method
        System.out.println("Office Computer Config: " + officeComputer); // Print the office computer configuration
    }
}

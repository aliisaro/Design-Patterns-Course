package Task14Builder;

public class ComputerDirector {

    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructComputer(String grade, String ramSize, String hardSize, String model, String system) {
        builder.buildProcessor(grade);
        builder.buildRAM(ramSize);
        builder.buildHardDrive(hardSize);
        builder.buildGraphicsCard(model);
        builder.buildSystem(system);
        return builder.getComputer(); // Return the completed computer
    }
}

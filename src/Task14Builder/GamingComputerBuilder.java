package Task14Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer("", "", "", "", "");
    }

    @Override
    public void buildProcessor(String grade) {
        computer.setProcessor(grade);
    }

    @Override
    public void buildRAM(String RAM) {
        computer.setRAM(RAM);
    }

    @Override
    public void buildHardDrive(String hardDrive) {
        computer.setHardDrive(hardDrive);
    }

    @Override
    public void buildGraphicsCard(String model) {
        computer.setGraphicsCard(model);
    }

    @Override
    public void buildSystem(String system) {
        computer.setSystem(system);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

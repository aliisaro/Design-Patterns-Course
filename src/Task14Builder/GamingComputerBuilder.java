package Task14Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer("", 0, 0, "", "");
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9-9900K");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive(2000);
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Nvidia GeForce RTX 2080 Ti");
    }

    @Override
    public void buildSystem() {
        computer.setSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

package Task14Builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer("", 0, 0, "", "");
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5-10400F");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive(500);
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Intel UHD Graphics 630");
    }

    @Override
    public void buildSystem() {
        computer.setSystem("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

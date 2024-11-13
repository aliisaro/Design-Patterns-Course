package Task14Builder;

public interface ComputerBuilder {
    public void buildProcessor(String grade);
    public void buildRAM(String ramSize);
    public void buildHardDrive(String hardSize);
    public void buildGraphicsCard(String model);
    public void buildSystem(String system);
    public Computer getComputer();
}

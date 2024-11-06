package Task14Builder;

public interface ComputerBuilder {
    public void buildProcessor();
    public void buildRAM();
    public void buildHardDrive();
    public void buildGraphicsCard();
    public void buildSystem();

    public Computer getComputer();
}

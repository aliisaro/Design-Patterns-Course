package Task14Builder;

public class Computer {
    private String processor;
    private String RAM;
    private String hardDrive;
    private String graphicsCard;
    private String system;

    public Computer(String processor, String RAM, String hardDrive, String graphicsCard, String system) {
        this.processor = processor;
        this.RAM = RAM;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.system = system;
    }

    // Setters
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setSystem(String system) {
        this.system = system;
    }


    public String toString() {
        return "Processor: " + processor + "\nRAM: " + RAM + "\nHard Drive: " + hardDrive +
                "\nGraphics Card: " + graphicsCard + "\nOperating System: " + system;
    }
}

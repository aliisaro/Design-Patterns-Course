package Task14Builder;

public class Computer {
    private String processor;
    private Integer RAM;
    private Integer hardDrive;
    private String graphicsCard;
    private String system;

    public Computer(String processor, int RAM, int hardDrive, String graphicsCard, String system) {
        this.processor = processor;
        this.RAM = RAM;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.system = system;
    }

    // Setters
    public void setHardDrive(Integer hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public void setSystem(String system) {
        this.system = system;
    }


    public String toString() {
        return "Computer [Processor=" + processor + ", RAM=" + RAM + "GB, Hard Drive=" + hardDrive + "GB, " +
                "Graphics Card=" + graphicsCard + ", Operating System=" + system + "]";
    }
}

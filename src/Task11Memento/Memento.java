package Task11Memento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private final String savedTime; //new code: store the time when the memento was created
    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.savedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); //new: code Format the time
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of options array
    }

    public boolean isSelected() {
        return isSelected;
    }

    //new code
    @Override
    public String getSavedTime() {
        return savedTime; // Return the saved time
    }

    @Override
    public String getDescription() {
        return "Options: " + options[0] + ", " + options[1] + ", " + options[2] + " | Click me button selected: " + isSelected;
    }
}

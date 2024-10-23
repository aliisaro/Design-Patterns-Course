package Task11Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; //new code

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        clearRedoHistory(); //new code
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }


    //new code
    public void undo() {
        if (!history.isEmpty()) {
            IMemento previousState = history.remove(history.size() - 1);
            redoHistory.add(model.createMemento()); // Save the current state to redo history
            model.restoreState(previousState);
            gui.updateGui();
        }
    }


    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }


    //new code
    private void clearRedoHistory() {
        redoHistory.clear(); // Clear redo history on new action
    }

    //new code
    public List<IMemento> getHistory() {
        return new ArrayList<>(history); // Return a copy to avoid modification
    }


    //new code
    public void restoreState(IMemento memento) {
        model.restoreState(memento); // Restore the state in the model
        gui.updateGui(); // Update the GUI to reflect the restored state
    }

    //new code
    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            history.add(model.createMemento()); // Save current state to undo
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

}
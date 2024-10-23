package Task11Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; //new code: list to store redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        clearRedoHistory(); //new code: clear redo history on new action
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        clearRedoHistory(); //new code: clear redo history on new action
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    public void undo() {
        if (!history.isEmpty()) {
            IMemento previousState = history.remove(history.size() - 1);
            redoHistory.add(model.createMemento()); // Save the current state to redo history
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    //new code: Clear redo history on new action
    private void clearRedoHistory() {
        redoHistory.clear();
    }

    //new code: Get the history of the application
    public List<IMemento> getHistory() {
        return new ArrayList<>(history);
    }

    //new code: restore state in the model and update gui to reflect the restored state
    public void restoreState(IMemento memento) {
        model.restoreState(memento);
    }

    //new code: redo the last undone action by restoring the state from the redo history
    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            history.add(model.createMemento());
            model.restoreState(nextState);
            gui.updateGui();
        }
    }
}
package Task11Memento;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

// Class to display the history of the application
// The Controller is passed to the constructor to allow the HistoryWindow to access the history

public class HistoryWindow {
    private final Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
        show();
    }

    private void show() {
        Stage historyStage = new Stage();
        ListView<String> listView = new ListView<>();

        List<IMemento> history = controller.getHistory();

        // Populate ListView with state descriptions
        for (IMemento memento : history) {
            String displayText = memento.getSavedTime() + " - " + memento.getDescription();
            listView.getItems().add(displayText);
        }

        listView.setOnMouseClicked(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                IMemento selectedMemento = history.get(selectedIndex);
                controller.restoreState(selectedMemento);
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 500, 400);
        historyStage.setScene(scene);
        historyStage.setTitle("History");
        historyStage.show();
    }
}

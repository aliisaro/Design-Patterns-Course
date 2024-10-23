package Task11Memento;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        //new code: history button
        Button historyButton = new Button("Show History");
        historyButton.setOnAction(event -> new HistoryWindow(controller));

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label label1 = new Label("Press Ctrl-Z to undo the last change.");
        label1.setPadding(insets);

        //new code: label for redo
        Label label2 = new Label("Press Ctrl-Y to undo the last change.");
        label2.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, historyButton, label1, label2);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        //new code
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown()) {
                if (event.getCode() == KeyCode.Z) { // Ctrl-Z: undo
                    System.out.println("Undo key combination pressed");
                    controller.undo();
                } else if (event.getCode() == KeyCode.Y) { // Ctrl-Y: redo
                    System.out.println("Redo key combination pressed");
                    controller.redo();
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
}

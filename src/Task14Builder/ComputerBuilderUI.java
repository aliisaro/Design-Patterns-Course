package Task14Builder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComputerBuilderUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize UI components
        Label computerTypeLabel = new Label("Select Computer Type:");
        ComboBox<String> computerTypeChoice = new ComboBox<>();
        computerTypeChoice.getItems().addAll("Gaming", "Office");

        Label processorLabel = new Label("Choose Processor:");
        ComboBox<String> processorChoice = new ComboBox<>();
        processorChoice.getItems().addAll("Intel Core i5", "Intel Core i7", "Intel Core i9");

        Label ramLabel = new Label("Choose RAM:");
        ComboBox<String> ramChoice = new ComboBox<>();
        ramChoice.getItems().addAll("8 GB", "16 GB", "32 GB");

        Label harddriveLabel = new Label("Choose Hard Drive size:");
        ComboBox<String> harddriveChoice = new ComboBox<>();
        harddriveChoice.getItems().addAll("256 GB", "512 GB", "1 TB");

        Label graphicsLabel = new Label("Choose Graphics Card:");
        ComboBox<String> graphicsChoice = new ComboBox<>();
        graphicsChoice.getItems().addAll("Nvidia GeForce RTX 2080 Ti", "Intel UHD Graphics 630");

        Label systemLabel = new Label("Choose Operating System:");
        ComboBox<String> systemChoice = new ComboBox<>();
        systemChoice.getItems().addAll("Windows 10", "Windows 11", "Linux", "MacOS");

        Button buildButton = new Button("Build Computer");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        buildButton.setOnAction(e -> {
            // Get the selected computer type
            String selectedComputerType = computerTypeChoice.getValue();

            // Based on the type, choose the correct builder
            ComputerBuilder builder;
            if ("Gaming".equals(selectedComputerType)) {
                builder = new GamingComputerBuilder();
            } else {
                builder = new OfficeComputerBuilder();
            }

            // Get the selected components
            String selectedProcessor = processorChoice.getValue();
            String selectedRAM = ramChoice.getValue();
            String selectedHarddrive = harddriveChoice.getValue();
            String selectedGraphics = graphicsChoice.getValue();
            String selectedSystem = systemChoice.getValue();

            // Build the computer
            builder.buildProcessor(selectedProcessor);
            builder.buildRAM(selectedRAM);
            builder.buildGraphicsCard(selectedGraphics);
            builder.buildHardDrive(selectedHarddrive);
            builder.buildSystem(selectedSystem);

            // Create the ComputerDirector and construct the computer
            ComputerDirector director = new ComputerDirector(builder);
            Computer customComputer = director.constructComputer(selectedProcessor, selectedRAM, selectedHarddrive , selectedGraphics, selectedSystem);

            // Display the built computer configuration
            resultArea.setText(selectedComputerType + " Computer build:\n" + customComputer.toString());
        });

        // Layout
        VBox layout = new VBox(10,
                computerTypeLabel,
                computerTypeChoice,
                processorLabel,
                processorChoice,
                ramLabel,
                ramChoice,
                harddriveLabel,
                harddriveChoice,
                graphicsLabel,
                graphicsChoice,
                systemLabel,
                systemChoice,
                buildButton,
                resultArea);

        // Padding and spacing
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);  // Center the content horizontally
        layout.setSpacing(10);

        // Create the scene with the layout and apply the CSS
        Scene scene = new Scene(layout, 400, 650);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Custom Computer Builder");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package Task17Flyweight;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) {
        // UI components
        Label title = new Label("Game");

        VBox layout = new VBox(10, title);

        // Set up padding and spacing
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        // Generate and display maps
        Map cityMap = new CityMap(5, 5);
        System.out.println("City Map:");
        cityMap.display();

        Map wildernessMap = new WildernessMap(10, 10);
        System.out.println("\nWilderness Map:");
        wildernessMap.display();

        // Create the scene and show the stage
        Scene scene = new Scene(layout, 400, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Map Generator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Game.class, args); // Proper way to launch JavaFX
    }
}


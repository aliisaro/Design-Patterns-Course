package Task17Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// The main Game class that sets up the JavaFX application and renders the map.
// This class uses a GraphicsContext, which is a JavaFX utility for drawing
// on a Canvas. The GraphicsContext provides methods to render shapes, images,
// and colors on the canvas. Here, it is used to:
// - Set the background color of the canvas.
// - Draw each tile of the map at its correct position.
// - Manage tile rendering sizes (e.g., width and height).

public class Game extends Application {
    private static final int MAP_WIDTH = 15;  // Number of tiles in the map (width)
    private static final int MAP_HEIGHT = 15; // Number of tiles in the map (height)
    private static final int WINDOW_WIDTH = 800;  // Initial window width
    private static final int WINDOW_HEIGHT = 800; // Initial window height

    @Override
    public void start(Stage primaryStage) {
        // Create a canvas with the same size as the window
        Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Calculate tile size based on window and map dimensions
        double tileWidth = WINDOW_WIDTH / (double) MAP_WIDTH;
        double tileHeight = WINDOW_HEIGHT / (double) MAP_HEIGHT;

        // Set the background color to green
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Create the map and render it once
        Map cityMap = new CityMap(MAP_WIDTH, MAP_HEIGHT);
        cityMap.render(gc, tileWidth, tileHeight);

        // uncomment to render wilderness map instead
        // Map wildernessMap = new WildernessMap(MAP_WIDTH, MAP_HEIGHT);
        // wildernessMap.render(gc, tileWidth, tileHeight);

        // Set up the scene and stage
        StackPane root = new StackPane(canvas);
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.setTitle("RPG Map Renderer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}

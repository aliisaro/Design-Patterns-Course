package Task17Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) {
        TileGraphicFactory tileGraphicFactory = new TileGraphicFactory();

        // Create a canvas
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Set the background color to green
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // Create and render the map
        Map cityMap = new CityMap(15, 15);
        cityMap.render(gc, tileGraphicFactory);

        // Uncomment the following lines to render the Wilderness Map instead
        // Map wildernessMap = new WildernessMap(15, 15);
        //wildernessMap.render(gc, tileGraphicFactory);

        StackPane root = new StackPane(canvas);
        primaryStage.setScene(new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT));
        primaryStage.setTitle("RPG Map Renderer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

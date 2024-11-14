package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    // Retrieve the graphic for a tile type or create it if it doesn't exist
    public static Image getTileGraphic(String tileType) {
        if (!tileGraphics.containsKey(tileType)) {
            // Use the package path to access images inside Task17Flyweight
            String imagePath = "/Task17Flyweight/" + tileType + ".png";
            System.out.println("Attempting to load image from: " + imagePath);

            Image image = new Image(TileGraphicFactory.class.getResourceAsStream(imagePath));
            if (image.isError()) {
                System.out.println("Error loading image: " + imagePath);
            }
            tileGraphics.put(tileType, image);
        }
        return tileGraphics.get(tileType);
    }

    public static void drawTile(GraphicsContext gc, String type, double x, double y, double tileWidth, double tileHeight) {
        Image graphic = getTileGraphic(type);
        gc.drawImage(graphic, x, y, tileWidth, tileHeight);  // Draw with specified width and height
    }

}

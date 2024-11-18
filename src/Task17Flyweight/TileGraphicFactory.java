package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

// The TileGraphicFactory ensures that each tile type's image is loaded only once and stored in a Map (tileGraphics).
// This follows the Flyweight pattern by sharing intrinsic state (tile images) among tiles to reduce memory usage.
// If multiple tiles of the same type are used, they all share the same image instance.
// In short: TileGraphicFactory manages tile images, ensures each type is loaded once, and optimizes memory.

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    // Gets or loads the image for a tile type.
    public static Image getTileGraphic(String tileType) {
        if (!tileGraphics.containsKey(tileType)) {
            String imagePath = "/Task17Flyweight/" + tileType + ".png";
            Image image = new Image(TileGraphicFactory.class.getResourceAsStream(imagePath));
            tileGraphics.put(tileType, image);
        }
        return tileGraphics.get(tileType);
    }

    // Draws a tile at a given position and size.
    public static void drawTile(GraphicsContext gc, String type, double x, double y, double tileWidth, double tileHeight) {
        Image graphic = getTileGraphic(type);
        gc.drawImage(graphic, x, y, tileWidth, tileHeight);
    }
}

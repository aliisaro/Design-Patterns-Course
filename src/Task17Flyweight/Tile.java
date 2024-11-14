package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;

public interface Tile {
    String getType();
    void draw(GraphicsContext gc, double x, double y, double tileWidth, double tileHeight);
}

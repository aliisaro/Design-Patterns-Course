package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;

// Represents a grid of tiles, renders them using shared graphics.
public abstract class Map {
    protected Tile[][] tiles;
    protected int width, height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
    }

    // Abstract method to create tiles, implemented by subclasses.
    protected abstract Tile createTile();

    // Fills the map with tiles.
    public void generateMap() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    // Draws the map on the canvas.
    public void render(GraphicsContext gc, double tileWidth, double tileHeight) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = tiles[i][j];
                // Draw each tile at the calculated position
                tile.draw(gc, i * tileWidth, j * tileHeight, tileWidth, tileHeight);
            }
        }
    }
}

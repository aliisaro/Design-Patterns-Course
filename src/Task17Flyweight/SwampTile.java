package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;

// Concrete classes implementing the Tile interface
class SwampTile implements Tile {
    @Override
    public String getType() {
        return "swamp";
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double tileWidth, double tileHeight) {
        TileGraphicFactory.drawTile(gc, this.getType(), x, y, tileWidth, tileHeight);
    }
}

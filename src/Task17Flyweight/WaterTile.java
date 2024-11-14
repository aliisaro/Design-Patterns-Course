package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;

class WaterTile implements Tile {
    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double tileWidth, double tileHeight) {
        TileGraphicFactory.drawTile(gc, this.getType(), x, y, tileWidth, tileHeight);
    }
}


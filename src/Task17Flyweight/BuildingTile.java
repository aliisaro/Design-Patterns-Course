package Task17Flyweight;

import javafx.scene.canvas.GraphicsContext;

class BuildingTile implements Tile {
    @Override
    public String getType() {
        return "building";
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double tileWidth, double tileHeight) {
        TileGraphicFactory.drawTile(gc, this.getType(), x, y, tileWidth, tileHeight);
    }
}

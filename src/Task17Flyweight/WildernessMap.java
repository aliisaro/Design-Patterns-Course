package Task17Flyweight;

import java.util.Random;

// A map with swamp, water, and forest tiles.
public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    // Randomly creates wilderness tiles.
    public Tile createTile() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            case 2: return new ForestTile();
            default: return new SwampTile();
        }
    }
}

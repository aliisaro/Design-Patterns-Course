package Task17Flyweight;

import java.util.Random;

// A map with road, forest, and building tiles.
public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    // Randomly creates city tiles.
    public Tile createTile() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return new RoadTile();
        }
    }
}

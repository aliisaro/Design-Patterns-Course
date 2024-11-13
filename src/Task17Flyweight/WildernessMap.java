package Task17Flyweight;

import java.util.Random;

//FactoryMethod1.WildernessMap class generates a map with swamp, water, and forest tiles
public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    //Factory method to create random tiles for a wilderness map
    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            case 2: return new ForestTile();
            default: return new SwampTile();
        }
    }
}
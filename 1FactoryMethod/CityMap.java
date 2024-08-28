import java.util.Random;

//CityMap class generates a map with road, forest, and building tiles
public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    //Factory method to create random tiles for a city map
    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return new RoadTile();
        }
    }
}
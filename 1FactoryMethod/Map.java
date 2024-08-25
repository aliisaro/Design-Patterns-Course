import java.util.Random;

public abstract class Map {
    protected Tile[][] tiles; // 2D array to store tiles
    protected int width;
    protected int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
    }

    public abstract Tile createTile();  // Abstract factory method

    public void generateMap() {  // Populate the map with tiles
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void display() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return new RoadTile(); // Fallback case
        }
    }
}

class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            case 2: return new ForestTile();
            default: return new SwampTile(); // Fallback case
        }
    }
}

import java.util.Random;

public class WildernessMap extends Map {

    public WildernessMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    @Override
    protected Tile createTile() {
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
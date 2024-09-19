package Task1FactoryMethod;

//Abstract class defining the common behavior for all maps
public abstract class Map {
    protected Tile[][] tiles; //2D array to store tiles
    protected int width;
    protected int height;

    //Constructor to initialize map size
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height]; //Initialize the 2D array
    }

    protected abstract Tile createTile(); //Abstract factory method for creating tiles

    //Method to generate the map by filling it with random tiles
    public void generateMap() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    //Method to display the map as a grid of characters
    public void display() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

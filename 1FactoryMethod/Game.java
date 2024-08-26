public class Game {
    public static void main(String[] args) {
        // Create a city map
        Map cityMap = new CityMap(5, 5);
        System.out.println("City Map:");
        cityMap.display();

        // Create a wilderness map
        Map wildernessMap = new WildernessMap(10, 10);
        System.out.println("\nWilderness Map:");
        wildernessMap.display();
    }
}

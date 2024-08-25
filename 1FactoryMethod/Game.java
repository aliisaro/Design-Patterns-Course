import java.util.Map;
import java.util.Scanner;

class Game {
    public Map createMap(String mapType, int width, int height) {
        if (mapType.equalsIgnoreCase("city")) {
            return new CityMap(width, height);
        } else if (mapType.equalsIgnoreCase("wilderness")) {
            return new WildernessMap(width, height);
        }
        return null; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a map type: city or wilderness");
        String mapType = scanner.nextLine();

        Game game = new Game();
        Map map = game.createMap(mapType, 5, 5); // Create a 5x5 map

        if (map != null) {
            map.display();
        } else {
            System.out.println("Invalid map type selected.");
        }
    }
}

package Task1FactoryMethod;

//AbstractMethod2.Main class to run the game
public class Game {
    public static void main(String[] args) {
        // Create and display a city map
        Map cityMap = new CityMap(5, 5);
        System.out.println("City FactoryMethod1.Map:");
        cityMap.display();

        // Create and display a wilderness map
        Map wildernessMap = new WildernessMap(10, 10);
        System.out.println("\nWilderness FactoryMethod1.Map:");
        wildernessMap.display();
    }
}

package Task21Facade;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FacadeAPI facade = new FacadeAPI();

        try {
            // Retrieve a Chuck Norris joke
            String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Joke: " + joke);

            // Retrieve exchange rates
            String exchangeRate = facade.getAttributeValueFromJson("https://open.er-api.com/v6/latest", "USD");
            System.out.println("Exchange Rate for USD: " + exchangeRate);
        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

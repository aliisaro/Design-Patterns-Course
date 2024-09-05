package Task4Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private List<Observer> observers;
    private int temperature;
    private final int minTemp = -10;
    private final int maxTemp = 40;
    private Random random;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();
        temperature = random.nextInt(maxTemp - minTemp + 1) + minTemp;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simulate temperature change
                int change = random.nextInt(3) - 1; // -1, 0, or 1
                temperature = Math.max(minTemp, Math.min(maxTemp, temperature + change));

                // Notify observers
                notifyObservers();

                // Wait a random time between 1-5 seconds
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


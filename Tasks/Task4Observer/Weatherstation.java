package Task4Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Weatherstation extends Thread {
    Random rand = new Random(); // create random object
    private int temperature = rand.nextInt(40); //initial random temperature
    private int randomTimeInverval;
    private int maxTemp = 40;
    private int minTemp = -50;

    //List that contains observer objects that will be updated of the temperatures
    List<ObserverInterface > listOfObservers = new ArrayList<>();

    public void run() {
        System.out.println("Thread started from weather station!\n");

        //Eternal loop
        while (temperature != 1000) {

            //Check wether temperature is within acceptable range
            if (temperature >= maxTemp) {
                temperature = maxTemp;
            } else if (temperature <= minTemp) {
                temperature = minTemp;
            }

            temperature += rand.nextInt(2) * 2 - 1;; // randomly change temperature

            notifyObservers();

            randomTimeInverval = rand.nextInt(2000) + 1000; // 1-3 seconds
            // Create a random time delay
            try {
                Thread.sleep(randomTimeInverval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void registerObserver(ObserverInterface observer) {
        listOfObservers.add(observer);
    }

    public void removeObserver(ObserverInterface observer) {
        listOfObservers.remove(observer);
    }

    public void notifyObservers() {
        // go through list of observers and notify them
        for (ObserverInterface observer : listOfObservers) {
            observer.updateTemperature(this.temperature);
        }
    }
}






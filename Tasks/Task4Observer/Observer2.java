package Task4Observer;

public class Observer2 implements ObserverInterface {

    @Override
    public void updateTemperature(int temperature) {
        System.out.println("Hello from observer 2! The current temperature is " + temperature);
    }
}

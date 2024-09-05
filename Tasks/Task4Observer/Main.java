package Task4Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);

        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        try {
            Thread.sleep(10000); // Let the simulation run for 10 seconds
            weatherStation.removeObserver(observer2); // Remove Observer 2
            System.out.println("Observer 2 removed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

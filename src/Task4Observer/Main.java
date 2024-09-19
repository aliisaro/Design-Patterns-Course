package Task4Observer;

public class Main {
    public static void main(String[] args) {

        //Create an instance weather station
        Weatherstation thread = new Weatherstation();

        // Create instances of both observers
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        // Register observers (add them to the observer list)
        thread.registerObserver(observer1);
        thread.registerObserver(observer2);

        // Start thread inside weatherstation
        thread.start();

        // remove observer 2 after 7 seconds
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.removeObserver(observer2);
    }
}

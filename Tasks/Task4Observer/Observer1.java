package Task4Observer;

//Concrete class
public class Observer1 implements ObserverInterface {

    @Override
    public void updateTemperature(int temperature) {
        System.out.println("This is observer 1! Current temperature is " + temperature);
    }
}

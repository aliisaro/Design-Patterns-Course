package Task2AbstractFactory.ConcreteClassesA;

import Task2AbstractFactory.AbstractClasses.Button;

public class ButtonA extends Button {
    @Override
    public void display() {
        // ASCII art for displaying the button in Style A
        System.out.println("|| " + text + " || ");
    }
}


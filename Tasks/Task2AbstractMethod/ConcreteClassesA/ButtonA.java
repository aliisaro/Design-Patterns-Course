package Task2AbstractMethod.ConcreteClassesA;

import Task2AbstractMethod.AbstractClasses.Button;

public class ButtonA extends Button {
    @Override
    public void display() {
        // ASCII art for displaying the button in Style A
        System.out.println("|| " + text + " || ");
    }
}


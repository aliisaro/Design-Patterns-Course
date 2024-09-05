package Task2AbstractFactory.ConcreteClassesB;

import Task2AbstractFactory.AbstractClasses.Button;

public class ButtonB extends Button {
    @Override
    public void display() {
        // ASCII art for displaying the button in Style B
        System.out.println("* " + text + " *");
    }
}

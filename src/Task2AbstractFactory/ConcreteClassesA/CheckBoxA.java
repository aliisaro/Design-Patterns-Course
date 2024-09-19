package Task2AbstractFactory.ConcreteClassesA;

import Task2AbstractFactory.AbstractClasses.CheckBox;

public class CheckBoxA extends CheckBox {
    @Override
    public void display() {
        // ASCII art for displaying the checkbox in Style A
        System.out.println("[ ] " + text);
    }
}

package Task2AbstractFactory.ConcreteClassesB;

import Task2AbstractFactory.AbstractClasses.CheckBox;

public class CheckBoxB extends CheckBox {
    @Override
    public void display() {
        // ASCII art for displaying the checkbox in Style B
        System.out.println("{  } " + text);
    }
}

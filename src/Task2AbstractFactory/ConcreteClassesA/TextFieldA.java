package Task2AbstractFactory.ConcreteClassesA;

import Task2AbstractFactory.AbstractClasses.TextField;

public class TextFieldA extends TextField {
    @Override
    public void display() {
        // ASCII art for displaying the text field in Style A
        System.out.println("<< " + text + "  >>");
    }
}

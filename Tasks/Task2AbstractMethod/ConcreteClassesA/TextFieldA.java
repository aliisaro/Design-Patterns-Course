package Task2AbstractMethod.ConcreteClassesA;

import Task2AbstractMethod.AbstractClasses.TextField;

public class TextFieldA extends TextField {
    @Override
    public void display() {
        // ASCII art for displaying the text field in Style A
        System.out.println("<< " + text + "  >>");
    }
}

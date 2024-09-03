package Task2AbstractMethod.ConcreteClassesB;

import Task2AbstractMethod.AbstractClasses.TextField;

public class TextFieldB extends TextField {
    @Override
    public void display() {
        // ASCII art for displaying the text field in Style B
        System.out.println("[ " + text + " ]");
    }
}

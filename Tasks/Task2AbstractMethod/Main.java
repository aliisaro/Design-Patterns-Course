package Task2AbstractMethod;

import Task2AbstractMethod.AbstractClasses.Button;
import Task2AbstractMethod.AbstractClasses.CheckBox;
import Task2AbstractMethod.AbstractClasses.TextField;

public class Main {
    public static void main(String[] args) {
        // Create a factory instance (either AFactory or BFactory)
        UIFactory factory = new AFactory();

        // Create UI elements using the factory
        Button button = factory.createButton("Click Me");
        TextField textField = factory.createTextField("Enter text...");
        CheckBox checkBox = factory.createCheckBox("Accept Terms");

        // Display the elements
        button.display();
        textField.display();
        checkBox.display();

        // Change the text of the elements dynamically
        button.setText("New text");
        textField.setText("New text");
        checkBox.setText("New text");

        // Display the elements again to see the updated content
        System.out.println("\nAfter updating text:");
        button.display();
        textField.display();
        checkBox.display();
    }
}

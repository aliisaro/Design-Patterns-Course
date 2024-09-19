package Task2AbstractFactory;

import Task2AbstractFactory.AbstractClasses.Button;
import Task2AbstractFactory.AbstractClasses.CheckBox;
import Task2AbstractFactory.AbstractClasses.TextField;

public abstract class UIFactory {
    // Abstract methods for creating UI elements
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract CheckBox createCheckBox(String text);
}


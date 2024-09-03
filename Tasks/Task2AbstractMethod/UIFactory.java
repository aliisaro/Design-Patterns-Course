package Task2AbstractMethod;

import Task2AbstractMethod.AbstractClasses.Button;
import Task2AbstractMethod.AbstractClasses.CheckBox;
import Task2AbstractMethod.AbstractClasses.TextField;

public abstract class UIFactory {
    // Abstract methods for creating UI elements
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract CheckBox createCheckBox(String text);
}


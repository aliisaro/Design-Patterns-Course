package Task2AbstractFactory;

import Task2AbstractFactory.AbstractClasses.Button;
import Task2AbstractFactory.AbstractClasses.CheckBox;
import Task2AbstractFactory.AbstractClasses.TextField;
import Task2AbstractFactory.ConcreteClassesB.ButtonB;
import Task2AbstractFactory.ConcreteClassesB.CheckBoxB;
import Task2AbstractFactory.ConcreteClassesB.TextFieldB;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        Button button = new ButtonB();
        button.setText(text);
        return button;
    }

    @Override
    public TextField createTextField(String text) {
        TextField textField = new TextFieldB();
        textField.setText(text);
        return textField;
    }

    @Override
    public CheckBox createCheckBox(String text) {
        CheckBox checkBox = new CheckBoxB();
        checkBox.setText(text);
        return checkBox;
    }
}

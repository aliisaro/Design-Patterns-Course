package Task2AbstractFactory;

import Task2AbstractFactory.AbstractClasses.Button;
import Task2AbstractFactory.AbstractClasses.CheckBox;
import Task2AbstractFactory.AbstractClasses.TextField;
import Task2AbstractFactory.ConcreteClassesA.ButtonA;
import Task2AbstractFactory.ConcreteClassesA.CheckBoxA;
import Task2AbstractFactory.ConcreteClassesA.TextFieldA;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        Button button = new ButtonA();
        button.setText(text);
        return button;
    }

    @Override
    public TextField createTextField(String text) {
        TextField textField = new TextFieldA();
        textField.setText(text);
        return textField;
    }

    @Override
    public CheckBox createCheckBox(String text) {
        CheckBox checkBox = new CheckBoxA();
        checkBox.setText(text);
        return checkBox;
    }
}

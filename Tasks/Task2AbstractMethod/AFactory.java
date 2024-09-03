package Task2AbstractMethod;

import Task2AbstractMethod.AbstractClasses.Button;
import Task2AbstractMethod.AbstractClasses.CheckBox;
import Task2AbstractMethod.AbstractClasses.TextField;
import Task2AbstractMethod.ConcreteClassesA.ButtonA;
import Task2AbstractMethod.ConcreteClassesA.CheckBoxA;
import Task2AbstractMethod.ConcreteClassesA.TextFieldA;

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

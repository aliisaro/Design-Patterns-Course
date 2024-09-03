package Task2AbstractMethod;

import Task2AbstractMethod.AbstractClasses.Button;
import Task2AbstractMethod.AbstractClasses.CheckBox;
import Task2AbstractMethod.AbstractClasses.TextField;
import Task2AbstractMethod.ConcreteClassesB.ButtonB;
import Task2AbstractMethod.ConcreteClassesB.CheckBoxB;
import Task2AbstractMethod.ConcreteClassesB.TextFieldB;

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

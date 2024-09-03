package Task2AbstractMethod.AbstractClasses;

public abstract class TextField {
    protected String text;
    public abstract void display();

    public void setText(String text) {
        this.text = text;
    }
}

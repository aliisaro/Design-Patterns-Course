package Task3Composite;

//Abstract class for both Departments and Employees.
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract int getTotalSalary();
    public abstract void printStructure(String indent);
    public abstract String toXML();
}

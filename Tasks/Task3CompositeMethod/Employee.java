package Task3CompositeMethod;

// Represents an individual employee
public class Employee extends Component {
    private int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to a leaf");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf");
    }

    @Override
    public int getTotalSalary() {
        return salary;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + name + " (" + salary + ")");
    }

    @Override
    public String toXML() {
        return "<employee>\n" +
                "  <name>" + name + "</name>\n" +
                "  <salary>" + salary + "</salary>\n" +
                "</employee>\n";
    }
}

package Task3Composite;

import java.util.ArrayList;
import java.util.List;

//Represents a department that can contain other Departments and Employees.
public class Department extends Component {
    private List<Component> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public int getTotalSalary() {
        // Sum salaries of all components in this department
        int total = 0;
        for (Component component : components) {
            total += component.getTotalSalary();
        }
        return total;
    }

    @Override
    public void printStructure(String indent) {
        // Print department name and structure of its components
        System.out.println(indent + name);
        for (Component component : components) {
            component.printStructure(indent + "  ");
        }
    }

    @Override
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<department>\n");
        xml.append("  <name>").append(name).append("</name>\n");
        for (Component component : components) {
            xml.append(component.toXML());
        }
        xml.append("</department>\n");
        return xml.toString();
    }
}

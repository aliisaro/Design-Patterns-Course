package Task3Composite;

public class Main {
    public static void main(String[] args) {
        Department itDepartment = new Department("IT Department"); // Root department

        Department softwareDevelopment = new Department("Software Development"); // Child department
        itDepartment.add(softwareDevelopment);
        softwareDevelopment.add(new Employee("John Doe", 50000));
        softwareDevelopment.add(new Employee("Jane Doe", 60000));
        softwareDevelopment.add(new Employee("Alice Doe", 70000));

        Department qualityAssurance = new Department("Quality Assurance"); // Child department
        itDepartment.add(qualityAssurance);
        qualityAssurance.add(new Employee("Bob Doe", 40000));
        qualityAssurance.add(new Employee("Eve Doe", 30000));
        qualityAssurance.add(new Employee("Carol Doe", 20000));

        // Print the structure
        itDepartment.printStructure("");

        // Print total salary
        System.out.println("\nTotal salary: " + itDepartment.getTotalSalary() +"\n");

        // Print XML representation
        System.out.println(itDepartment.toXML());
    }
}

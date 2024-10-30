package Task13Visitor;

public class File implements FileSystemElement {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this); // Accept the visitor for this file
    }
}

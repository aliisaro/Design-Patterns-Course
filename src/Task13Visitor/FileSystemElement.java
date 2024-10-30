package Task13Visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}

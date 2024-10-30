package Task13Visitor;

public interface FileSystemVisitor {

    void visit(File file);

    void visit(Directory directory);
}

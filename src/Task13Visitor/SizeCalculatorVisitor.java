package Task13Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}

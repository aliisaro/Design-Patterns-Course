package Task13Visitor;

import java.util.ArrayList;

public class Directory implements FileSystemElement {

    // ArrayList to hold the FileSystemElement objects
    ArrayList<FileSystemElement> elements = new ArrayList<FileSystemElement>();

    public ArrayList<FileSystemElement> getElements() {
        return elements;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}

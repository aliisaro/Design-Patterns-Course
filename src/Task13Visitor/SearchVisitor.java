package Task13Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchName;       // exact name to search for
    private String searchCriteria;    // file extension to search for

    // A list to store files that match specific criteria.
    private List<String> filesWithCriteria = new ArrayList<>();

    public SearchVisitor(String searchName, String searchCriteria) {
        this.searchName = searchName;
        this.searchCriteria = searchCriteria;
    }

    public List<String> getFiles() {
        return filesWithCriteria;
    }

    public boolean isFound() {
        return !filesWithCriteria.isEmpty();
    }

    @Override
    public void visit(File file) {
        // Check if the file name matches the search name or has the specified extension
        if (file.getName().equals(searchName) || file.getName().endsWith(searchCriteria)) {
            filesWithCriteria.add(file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        // Recursively visit each element in the directory
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this); // Accept the visitor to allow traversal
        }
    }
}

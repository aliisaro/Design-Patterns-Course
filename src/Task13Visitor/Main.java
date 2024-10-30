package Task13Visitor;

public class Main {
    public static void main(String[] args) {
        // Create directories and files
        Directory root = new Directory();
        Directory sub = new Directory();
        File fileA = new File("fileA.txt", 10);
        File fileB = new File("fileB.txt", 20);
        File fileC = new File("fileC.jpg", 30);
        File fileD = new File("fileD.png", 40);

        // Build the file system structure
        root.addElement(fileA);
        root.addElement(sub);
        sub.addElement(fileB);
        sub.addElement(fileC);
        sub.addElement(fileD);

        // Create a SizeCalculatorVisitor
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        root.accept(sizeCalculatorVisitor);

        // Output the total size of files
        System.out.println("Total size of all files: " + sizeCalculatorVisitor.getTotalSize() + " MB");

        // Create and apply SearchVisitor that searches for fileD.png as well as files that end with.jpg
        SearchVisitor searchVisitor = new SearchVisitor("fileD.png", ".jpg");
        root.accept(searchVisitor);

        // Output the search results
        if (searchVisitor.isFound()) {
            System.out.println("Found matching files: " + searchVisitor.getFiles());
        } else {
            System.out.println("No matching files found.");
        }
    }
}



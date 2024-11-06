package Task13Visitor;

public class Main {
    public static void main(String[] args) {
        // Create directories and files
        Directory root = new Directory();  // root directory
        Directory sub1 = new Directory();  // First subdirectory
        Directory sub2 = new Directory();  // Second subdirectory

        File fileA = new File("fileA.txt", 10);
        File fileB = new File("fileB.txt", 20);
        File fileC = new File("fileC.txt", 30);
        File fileD = new File("fileD.jpg", 40);
        File fileE = new File("fileE.png", 50);

        // Build the file system structure
        root.addElement(sub1);
        root.addElement(sub2);
        sub1.addElement(fileA);
        sub1.addElement(fileB);
        sub1.addElement(fileC);
        sub2.addElement(fileD);
        sub2.addElement(fileE);

        // Create a SizeCalculatorVisitor
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        root.accept(sizeCalculatorVisitor);

        // Output the total size of files
        System.out.println("Total size of all files: " + sizeCalculatorVisitor.getTotalSize() + " MB");

        // Create and apply SearchVisitor that searches for fileE.png as well as files that end with .jpg
        SearchVisitor searchVisitor = new SearchVisitor("fileE.png", ".jpg");
        root.accept(searchVisitor);

        // Output the search results
        if (searchVisitor.isFound()) {
            System.out.println("Found matching files: " + searchVisitor.getFiles());
        } else {
            System.out.println("No matching files found.");
        }
    }
}

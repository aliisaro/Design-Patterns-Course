package Task12Proxy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create several user instances
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Create document instances (both protected and unprotected)
        Document unprotectedDocument = new Document("1", LocalDate.now(), "This is the content inside the unprotected document.");
        Document protectedDocument = new Document("2", LocalDate.now(), "This is the content inside the protected document.");

        // Create an AccessControlService instance
        AccessControlService accessControlService = AccessControlService.getInstance();

        // Add permissions for the protected document
        accessControlService.addPermission("2", "Alice");  // Allow Alice to access the protected document

        // Create DocumentProxy for the protected document
        DocumentProxy protectedDocumentProxy = new DocumentProxy(protectedDocument);

        // Attempt to access unprotected document
        System.out.println("Alice accessing unprotected document:");
        System.out.println(unprotectedDocument.getContent(alice)); // Direct access to unprotected document

        System.out.println("\nBob accessing unprotected document:");
        System.out.println(unprotectedDocument.getContent(bob)); // Direct access to unprotected document

        // Attempt to access protected document
        try {
            System.out.println("\nAlice accessing protected document:");
            System.out.println(protectedDocumentProxy.getContent(alice)); // Should succeed
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nBob accessing protected document:");
            System.out.println(protectedDocumentProxy.getContent(bob)); // Should be denied
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}

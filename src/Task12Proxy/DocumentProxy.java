package Task12Proxy;

import java.time.LocalDate;

public class DocumentProxy implements DocumentInterface {
    private Document realDocument; // The actual document being proxied

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument; // Store the reference to the real document
    }

    @Override
    public String getContent(User user) {
        // Check access permissions using AccessControlService
        if (AccessControlService.getInstance().isAllowed(user, realDocument.getDocumentId())) {
            return realDocument.getContent(user); // Return content if allowed
        } else {
            throw new AccessDeniedException(); // Throw exception if not allowed
        }
    }

    @Override
    public LocalDate getCreationDate() {
        return realDocument.getCreationDate(); // Return the creation date from the real document
    }
}

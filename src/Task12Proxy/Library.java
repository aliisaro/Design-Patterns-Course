package Task12Proxy;

import java.util.HashMap;

public class Library {
    private HashMap<String, DocumentInterface> documents = new HashMap<>(); // HashMap to store the documents with the document ID and the document

    public void addDocument(Document document) {
        // Store the real document
        documents.put(document.getDocumentId(), document);

        // Create and store the proxy if the document is protected
        if (document.getDocumentId().equals("2")) { // Assuming "2" is the protected document ID
            DocumentProxy proxy = new DocumentProxy(document);
            documents.put(proxy.getCreationDate().toString(), proxy); // Use another identifier for the proxy
        }
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id); // Return either the real document or its proxy
    }
}

package Task12Proxy;

import java.util.HashMap;

public class AccessControlService {
    private static AccessControlService instance;
    private HashMap<String, String> permissions; // HashMap to store the permissions with the document ID and the username

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void addPermission(String documentId, String username) {
        permissions.put(documentId, username); // Set permission for the document
    }

    public boolean isAllowed(User user, String documentId) {
        return permissions.containsKey(documentId) && permissions.get(documentId).equals(user.getUsername());
    }
}

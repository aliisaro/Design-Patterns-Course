package Task12Proxy;

// Custom exception class that extends RuntimeException
public class AccessDeniedException extends RuntimeException {

    // Default constructor with a default message
    public AccessDeniedException() {
        super("Access Denied");
    }

    // Constructor that accepts a custom message
    public AccessDeniedException(String message) {
        super(message);
    }
}

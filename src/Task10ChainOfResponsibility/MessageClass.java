package Task10ChainOfResponsibility;

public class MessageClass {
    private String messageContent;
    private String senderEmail;
    private messageType type;

    public enum messageType {
        compensationClaim,
        contactRequest,
        developmentSuggestion,
        generalFeedback
    }

    // colors to make the output more readable
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m"; // Reset color

    // Constructor
    public MessageClass(String messageContent, String senderEmail, messageType type) {
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
        this.type = type;
    }

    // Getters
    public String getContent() {
        return messageContent;
    }

    public String getEmail() {
        return senderEmail;
    }

    public messageType getType() {
        return type;
    }

}

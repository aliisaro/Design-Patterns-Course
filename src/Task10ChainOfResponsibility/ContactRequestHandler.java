package Task10ChainOfResponsibility;
import static Task10ChainOfResponsibility.MessageClass.*; // Import the colors

public class ContactRequestHandler implements HandlerInterface {
    private HandlerInterface nextHandler; // Object to hold the next handler in the chain

    @Override
    public void handleMessage(MessageClass message) {
        if (message.getType() == MessageClass.messageType.contactRequest) {
            System.out.println(YELLOW + "Handling contact request: '" + message.getContent() + "'." + RESET);
            System.out.println(GREEN + "Response: \"Your contact request has been forwarded to customer support.\"\n" + RESET);
        } else if (nextHandler != null) {
            System.out.println(RED + "ContactRequestHandler passed the message by '" + message.getEmail() + "' to the next handler." + RESET);
            nextHandler.handleMessage(message); // Pass to the next handler
        }
    }

    @Override
    public void setNextHandler(HandlerInterface nextHandler) {
        this.nextHandler = nextHandler;
    }
}

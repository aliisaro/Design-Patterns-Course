package Task10ChainOfResponsibility;
import static Task10ChainOfResponsibility.MessageClass.*; // Import the colors

public class SuggestionHandler implements HandlerInterface {
    private HandlerInterface nextHandler; // Object to hold the next handler in the chain

    @Override
    public void handleMessage(MessageClass message) {
        if (message.getType() == MessageClass.messageType.developmentSuggestion) {
            System.out.println(YELLOW + "Handling development suggestion: '" + message.getContent() + "'." + RESET);
            System.out.println(GREEN + "Response: \"Thank you for your suggestion! It has been logged for review.\"\n" + RESET);
        } else if (nextHandler != null) {
            System.out.println(RED + "SuggestionHandler passed the message by '" + message.getEmail() + "' to the next handler." + RESET);
            nextHandler.handleMessage(message); // Pass to the next handler
        }
    }

    @Override
    public void setNextHandler(HandlerInterface nextHandler) {
        this.nextHandler = nextHandler;
    }
}

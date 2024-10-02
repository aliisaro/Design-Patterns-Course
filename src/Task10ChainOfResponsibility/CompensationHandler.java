package Task10ChainOfResponsibility;
import static Task10ChainOfResponsibility.MessageClass.*; // Import the colors

public class CompensationHandler implements HandlerInterface {
    private HandlerInterface nextHandler; // Object to hold the next handler in the chain

    @Override
    public void handleMessage(MessageClass message) {
        if (message.getType() == MessageClass.messageType.compensationClaim) {
            System.out.println(YELLOW + "Handling compensation claim: '" + message.getContent() + "'." + RESET);
            System.out.println(GREEN + "Response: \"Your compensation claim is under review.\"\n" + RESET);
        } else if (nextHandler != null) {
            System.out.println(RED + "CompensationHandler passed the message by '"+ message.getEmail() + "' to the next handler." + RESET);
            nextHandler.handleMessage(message); // Pass to the next handler
        }
    }

    @Override
    public void setNextHandler(HandlerInterface nextHandler) {
        this.nextHandler = nextHandler;
    }
}

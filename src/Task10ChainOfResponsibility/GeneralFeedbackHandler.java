package Task10ChainOfResponsibility;
import static Task10ChainOfResponsibility.MessageClass.*; // Import the colors

public class GeneralFeedbackHandler implements HandlerInterface {
    private HandlerInterface nextHandler; // Object to hold the next handler in the chain

    @Override
    public void handleMessage(MessageClass message) {
            if (message.getType() == MessageClass.messageType.generalFeedback) {
                System.out.println(YELLOW + "Handling general feedback: '" + message.getContent() + "'." + RESET);
                System.out.println(GREEN + "Response: \"Thank you for your feedback! We appreciate your input.\"\n" + RESET);
            } else if (nextHandler != null) {
                System.out.println(RED + "GeneralFeedbackHandler passed the message by '" + message.getEmail() + "' to the next handler." + RESET);
                nextHandler.handleMessage(message); // Pass to the next handler

            }
    }

    @Override
    public void setNextHandler(HandlerInterface nextHandler) {
        this.nextHandler = nextHandler;
    }
}

package Task10ChainOfResponsibility;
import static Task10ChainOfResponsibility.MessageClass.messageType.*; // Import the enum values

public class Main {
    public static void main(String[] args) {

        // Create handler instances
        CompensationHandler compensationHandler = new CompensationHandler();
        ContactRequestHandler contactHandler = new ContactRequestHandler();
        SuggestionHandler suggestionHandler = new SuggestionHandler();
        GeneralFeedbackHandler feedbackHandler = new GeneralFeedbackHandler();

        // Set the next handler in the chain
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        // Create message instances
        MessageClass message1 = new MessageClass("I like your product.", "me@me.com", generalFeedback);
        MessageClass message2 = new MessageClass("I have a suggestion for your product.", "someome@gmail.com", developmentSuggestion);
        MessageClass message3 = new MessageClass("I would like to request a refund.", "dude@email.com", compensationClaim);
        MessageClass message4 = new MessageClass("I would like to contact you.", "bro.bro.com", contactRequest);

        // Send the messages through the chain
        compensationHandler.handleMessage(message1);
        compensationHandler.handleMessage(message2);
        compensationHandler.handleMessage(message3);
        compensationHandler.handleMessage(message4);
    }
}

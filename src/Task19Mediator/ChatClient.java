package Task19Mediator;

public class ChatClient {
    private String username;
    private ChatMediator mediator;
    private ChatClientController controller;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        this.mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String recipient) {
        mediator.sendMessage(message, username, recipient);
    }

    public void receiveMessage(String message, String sender) {
        controller.displayMessage(sender + ": " + message);
    }

    public void setController(ChatClientController controller) {
        this.controller = controller;
    }
}

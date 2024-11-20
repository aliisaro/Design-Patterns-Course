package Task19Mediator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientController {
    private TextArea chatArea;
    private TextField messageField;
    private TextField recipientField;
    private Button sendButton;

    private ChatClient client;

    public void setClient(ChatClient client) {
        this.client = client;
        this.client.setController(this);
    }

    public void display(Stage stage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);

        Label messsagelabel = new Label("Message:");
        messageField = new TextField();

        Label recipientLabel = new Label("Recipient:");
        recipientField = new TextField();

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String message = messageField.getText();
            String recipient = recipientField.getText();
            if (!message.isEmpty() && !recipient.isEmpty()) {
                // Display the user's sent message in the chat area
                displayMessage("You (to " + recipient + "): " + message);
                // Send the message via the client
                client.sendMessage(message, recipient);
                // Clear the message field
                messageField.clear();
            }
        });

        VBox layout = new VBox(10, chatArea, messsagelabel, messageField, recipientLabel,recipientField, sendButton);
        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle(client.getUsername());
        stage.setScene(scene);
        stage.show();
    }

    public void displayMessage(String message) {
        chatArea.appendText(message + "\n");
    }
}

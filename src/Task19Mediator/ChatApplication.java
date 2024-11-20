package Task19Mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApplication extends Application {
    private ChatMediator mediator = new ChatMediatorImpl();

    @Override
    public void start(Stage primaryStage) {
        createClientWindow("Harry");
        createClientWindow("Ron");
        createClientWindow("Hermione");
    }

    private void createClientWindow(String username) {
        ChatClientController controller = new ChatClientController();
        ChatClient client = new ChatClient(username, mediator);
        controller.setClient(client);

        Stage stage = new Stage();
        controller.display(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

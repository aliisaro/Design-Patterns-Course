package Task18Prototype;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private List<Recommendation> recommendations = new ArrayList<>();
    private ListView<Recommendation> recommendationListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {

        // Create the main layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Action buttons for managing recommendations
        HBox actionButtons = new HBox(10);
        Button addRecommendationButton = new Button("Add Recommendation");
        Button cloneButton = new Button("Clone Recommendation");
        Button modifyButton = new Button("Modify Recommendation");
        Button deleteButton = new Button("Delete Recommendation");
        actionButtons.getChildren().addAll(addRecommendationButton, cloneButton, modifyButton, deleteButton);

        // ListView to display the list of recommendations
        recommendationListView.getItems().addAll(recommendations);
        root.getChildren().addAll(new Label("Recommendations"), recommendationListView, actionButtons);

        // Define button actions
        addRecommendationButton.setOnAction(e -> addRecommendation());
        cloneButton.setOnAction(e -> cloneSelectedRecommendation());
        modifyButton.setOnAction(e -> modifySelectedRecommendation(primaryStage));
        deleteButton.setOnAction(e -> deleteSelectedRecommendation());

        // Set up and display the primary stage
        Scene scene = new Scene(root, 630, 400);
        primaryStage.setTitle("Book Recommendation System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Methods for button actions
    private void addRecommendation() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Recommendation");
        dialog.setHeaderText("Create a New Recommendation");
        dialog.setContentText("Enter Target Audience:");

        dialog.showAndWait().ifPresent(targetAudience -> {
            Recommendation newRecommendation = new Recommendation(targetAudience, new ArrayList<>());
            recommendations.add(newRecommendation);
            recommendationListView.getItems().add(newRecommendation);
            showAlert("Success", "New recommendation list added.");
        });
    }

    private void deleteSelectedRecommendation() {
        Recommendation selected = recommendationListView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            recommendations.remove(selected); // Remove from the underlying list
            recommendationListView.getItems().remove(selected); // Remove from ListView
            showAlert("Success", "Recommendation deleted successfully.");
        } else {
            showAlert("Error", "No recommendation selected to delete.");
        }
    }

    private void cloneSelectedRecommendation() {
        Recommendation selected = recommendationListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Recommendation clone = selected.clone();
            clone.setTargetAudience(selected.getTargetAudience() + " (Clone)");
            recommendations.add(clone);
            recommendationListView.getItems().add(clone);
        } else {
            showAlert("Error", "No recommendation selected to clone.");
        }
    }

    private void modifySelectedRecommendation(Stage primaryStage) {
        Recommendation selected = recommendationListView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "No recommendation selected to modify.");
            return;
        }

        Stage dialog = new Stage();
        dialog.setTitle("Modify Recommendation");

        VBox dialogLayout = new VBox(10);
        dialogLayout.setPadding(new Insets(10));

        // Target Audience Field
        TextField targetAudienceField = new TextField(selected.getTargetAudience());
        targetAudienceField.setPromptText("Enter Target Audience");

        // Books Table
        TableView<Book> booksTable = new TableView<>();
        booksTable.getItems().addAll(selected.getRecommendedBooks());

        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitle()));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAuthor()));

        TableColumn<Book, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGenre()));

        TableColumn<Book, String> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getPublicationYear())));

        booksTable.getColumns().addAll(titleColumn, authorColumn, genreColumn, yearColumn);

        // Buttons for Adding/Removing Books
        Button addBookButton = new Button("Add Book");
        Button removeBookButton = new Button("Remove Book");

        HBox buttonBox = new HBox(10, addBookButton, removeBookButton);

        addBookButton.setOnAction(e -> addBookToSelectedRecommendation(selected, booksTable));

        removeBookButton.setOnAction(e -> {
            Book bookToRemove = booksTable.getSelectionModel().getSelectedItem();
            if (bookToRemove != null) {
                selected.removeBook(bookToRemove);
                booksTable.getItems().remove(bookToRemove);
            } else {
                showAlert("Error", "No book selected to remove.");
            }
        });

        // Save Changes Button
        Button saveChangesButton = new Button("Save Changes");
        saveChangesButton.setOnAction(e -> {
            selected.setTargetAudience(targetAudienceField.getText());
            recommendationListView.refresh(); // Refresh the ListView to show updated audience
            dialog.close();
        });

        dialogLayout.getChildren().addAll(
                new Label("Edit Target Audience:"), targetAudienceField,
                new Label("Books:"), booksTable,
                buttonBox, saveChangesButton
        );

        Scene dialogScene = new Scene(dialogLayout, 600, 500);
        dialog.setScene(dialogScene);
        dialog.initOwner(primaryStage);
        dialog.showAndWait();
    }

    private void addBookToSelectedRecommendation(Recommendation recommendation, TableView<Book> booksTable) {
        Dialog<Book> dialog = new Dialog<>();
        dialog.setTitle("Add Book");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField authorField = new TextField();
        authorField.setPromptText("Author");

        TextField genreField = new TextField();
        genreField.setPromptText("Genre");

        TextField yearField = new TextField();
        yearField.setPromptText("Year");

        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Author:"), 0, 1);
        grid.add(authorField, 1, 1);
        grid.add(new Label("Genre:"), 0, 2);
        grid.add(genreField, 1, 2);
        grid.add(new Label("Year:"), 0, 3);
        grid.add(yearField, 1, 3);

        dialog.getDialogPane().setContent(grid);
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        dialog.setResultConverter(button -> {
            if (button == addButtonType) {
                try {
                    return new Book(
                            titleField.getText(),
                            authorField.getText(),
                            genreField.getText(),
                            Integer.parseInt(yearField.getText())
                    );
                } catch (NumberFormatException e) {
                    showAlert("Error", "Invalid year format.");
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(newBook -> {
            recommendation.addBook(newBook);
            booksTable.getItems().add(newBook);
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

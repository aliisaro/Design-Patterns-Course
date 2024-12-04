package Task22Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainGUI extends Application {

  private static final int GRID_SIZE = 8; // 8x8 grid
  private static final int CELL_SIZE = 50; // Size of each cell in pixels
  private final boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE]; // Grid state
  private final Cursor cursor = new Cursor(0, 0); // Cursor starts at (0,0)

  @Override
  public void start(Stage primaryStage) {
    VBox root = new VBox();
    GridPane gridPane = createGrid();
    Button generateCodeButton = new Button("Generate Code");

    // Handle the Generate Code button
    generateCodeButton.setOnAction(event -> {
      Command generateCodeCommand = new GenerateCodeCommand(grid);
      generateCodeCommand.execute();
    });

    // Set up key event handling for cursor movement and pixel toggling
    Scene scene = new Scene(root, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE + 50);
    scene.addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case UP:
          new MoveCursorUpCommand(cursor).execute();
          break;
        case DOWN:
          new MoveCursorDownCommand(cursor).execute();
          break;
        case LEFT:
          new MoveCursorLeftCommand(cursor).execute();
          break;
        case RIGHT:
          new MoveCursorRightCommand(cursor).execute();
          break;
        case SPACE:
          new TogglePixelCommand(cursor, grid).execute();
          updateGrid(gridPane);
          event.consume();
          break;
        default:
          System.out.println("Unhandled key: " + event.getCode());
      }
      updateGrid(gridPane); // Ensure grid refreshes after any movement
    });

    root.getChildren().addAll(gridPane, generateCodeButton);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Pixel Art Editor");
    primaryStage.show();
  }

  private GridPane createGrid() {
    GridPane gridPane = new GridPane();
    gridPane.setGridLinesVisible(true);

    for (int y = 0; y < GRID_SIZE; y++) {
      for (int x = 0; x < GRID_SIZE; x++) {
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFill(Color.WHITE); // Default "off" state
        gridPane.add(cell, x, y);
      }
    }
    return gridPane;
  }

  private void updateGrid(GridPane gridPane) {
    gridPane.getChildren().clear(); // Clear the grid to redraw

    for (int y = 0; y < GRID_SIZE; y++) {
      for (int x = 0; x < GRID_SIZE; x++) {
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFill(grid[y][x] ? Color.BLACK : Color.WHITE); // Set pixel state
        if (x == cursor.getX() && y == cursor.getY()) {
          cell.setStroke(Color.RED); // Highlight cursor
          cell.setStrokeWidth(2);
        } else {
          cell.setStroke(Color.LIGHTGRAY); // Default border
        }
        gridPane.add(cell, x, y);
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

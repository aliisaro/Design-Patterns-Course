package Task22Command;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGUI extends Application {

  private static final int GRID_SIZE = 8; // 8x8 grid
  private static final int CELL_SIZE = 50; // Size of each cell in pixels
  private final boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE]; // Grid state
  private int cursorX = 0; // Cursor X-coordinate
  private int cursorY = 0; // Cursor Y-coordinate

  @Override
  public void start(Stage primaryStage) {
    VBox root = new VBox();
    GridPane gridPane = createGrid();
    updateGrid(gridPane); // Show the red box initially

    // Create button button
    Button generateCodeButton = new Button("Create Code");
    VBox.setMargin(generateCodeButton, new Insets(5));
    generateCodeButton.setOnAction(event -> {
      new GenerateCodeCommand(grid).execute();
      root.requestFocus(); // Restore focus to the root node
    });

    // Labels for instructions
    Label moveInstructions = new Label("Use arrow keys to move on the grid");
    VBox.setMargin(moveInstructions, new Insets(5));
    Label toggleInstructions = new Label("Press space bar to toggle a pixel");
    VBox.setMargin(toggleInstructions, new Insets(5));


    // Set up key event handling for cursor movement and pixel toggling
    Scene scene = new Scene(root, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE + 100);
    scene.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP:
          new MoveCursorUpCommand(this).execute();
          break;
        case DOWN:
          new MoveCursorDownCommand(this).execute();
          break;
        case LEFT:
          new MoveCursorLeftCommand(this).execute();
          break;
        case RIGHT:
          new MoveCursorRightCommand(this).execute();
          break;
        case SPACE:
          new TogglePixelCommand(this).execute();
          break;
        default:
          System.out.println("Unhandled key: " + event.getCode());
      }
      updateGrid(gridPane); // Refresh the grid
    });

    root.getChildren().addAll(gridPane, generateCodeButton, moveInstructions, toggleInstructions);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Pixel Art Editor");
    primaryStage.show();
    root.requestFocus(); // Set focus to the root node
  }

  public GridPane createGrid() {
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

  public void updateGrid(GridPane gridPane) {
    gridPane.getChildren().clear();

    for (int y = 0; y < GRID_SIZE; y++) {
      for (int x = 0; x < GRID_SIZE; x++) {
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFill(grid[y][x] ? Color.BLACK : Color.WHITE);
        if (x == cursorX && y == cursorY) { // Highlight cursor
          cell.setStroke(Color.RED);
          cell.setStrokeType(javafx.scene.shape.StrokeType.INSIDE); // Ensure stroke is inside
          cell.setStrokeWidth(2);
        } else {
          cell.setStroke(Color.LIGHTGRAY); // Default border
          cell.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
          cell.setStrokeWidth(1);
        }
        gridPane.add(cell, x, y);
      }
    }
  }

  public boolean[][] getGrid() {
    return grid;
  }

  public int getGridSize() {
    return GRID_SIZE;
  }

  public int getCursorX() {
    return cursorX;
  }

  public void setCursorX(int cursorX) {
    this.cursorX = cursorX;
  }

  public int getCursorY() {
    return cursorY;
  }

  public void setCursorY(int cursorY) {
    this.cursorY = cursorY;
  }

  public static void main(String[] args) {
    launch(args);
  }
}

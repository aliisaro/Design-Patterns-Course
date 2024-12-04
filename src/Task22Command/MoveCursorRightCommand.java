package Task22Command;

public class MoveCursorRightCommand implements Command {
  private Cursor cursor; // Reference to the cursor

  public MoveCursorRightCommand(Cursor cursor) {
    this.cursor = cursor;
  }

  @Override
  public void execute() {
    if (cursor.getX() < 7) { // Ensure cursor doesn't move out of bounds
      cursor.setX(cursor.getX() + 1); // Move the cursor right
    }
  }
}

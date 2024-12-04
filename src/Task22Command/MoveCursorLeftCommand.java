package Task22Command;

public class MoveCursorLeftCommand implements Command {
  private Cursor cursor; // Reference to the cursor

  public MoveCursorLeftCommand(Cursor cursor) {
    this.cursor = cursor;
  }

  @Override
  public void execute() {
    if (cursor.getX() > 0) { // Ensure cursor doesn't move out of bounds
      cursor.setX(cursor.getX() - 1); // Move the cursor left
    }
  }
}

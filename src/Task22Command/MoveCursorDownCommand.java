package Task22Command;

public class MoveCursorDownCommand implements Command {
  private Cursor cursor; // Reference to the cursor

  // Constructor to accept the cursor object
  public MoveCursorDownCommand(Cursor cursor) {
    this.cursor = cursor;
  }

  @Override
  public void execute() {
    if (cursor.getY() < 7) { // Ensure cursor doesn't move out of bounds
      cursor.setY(cursor.getY() + 1); // Move the cursor down
    }
  }
}

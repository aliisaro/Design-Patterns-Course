package Task22Command;

public class MoveCursorUpCommand implements Command{
  private Cursor cursor; // Reference to the cursor

  // Constructor to accept the cursor object
  public MoveCursorUpCommand(Cursor cursor) {
    this.cursor = cursor;
  }

  @Override
  public void execute() {
    if (cursor.getY() > 0) { // Ensure cursor doesn't move out of bounds
      cursor.setY(cursor.getY() - 1); // Move the cursor up
    }
  }
}

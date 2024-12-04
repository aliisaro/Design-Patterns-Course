package Task22Command;

public class TogglePixelCommand implements Command {
  private final Cursor cursor;
  private final boolean[][] grid;

  public TogglePixelCommand(Cursor cursor, boolean[][] grid) {
    this.cursor = cursor;
    this.grid = grid;
  }

  @Override
  public void execute() {
    int x = cursor.getX();
    int y = cursor.getY();
    grid[y][x] = !grid[y][x]; // Toggle the pixel state
  }
}

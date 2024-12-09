package Task22Command;

public class TogglePixelCommand implements Command {
  private final MainGUI gui;

  public TogglePixelCommand(MainGUI gui) {
    this.gui = gui;
  }

  @Override
  public void execute() {
    int x = gui.getCursorX();
    int y = gui.getCursorY();
    boolean[][] grid = gui.getGrid();

    grid[y][x] = !grid[y][x];
  }
}

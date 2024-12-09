package Task22Command;

public class MoveCursorDownCommand implements Command {
  private final MainGUI gui;

  public MoveCursorDownCommand(MainGUI gui) {
    this.gui = gui;
  }

  @Override
  public void execute() {
    if (gui.getCursorY() < gui.getGridSize() - 1) {
      gui.setCursorY(gui.getCursorY() + 1);
    }
  }
}

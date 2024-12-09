package Task22Command;

public class MoveCursorUpCommand implements Command {
  private final MainGUI gui;

  public MoveCursorUpCommand(MainGUI gui) {
    this.gui = gui;
  }

  @Override
  public void execute() {
    if (gui.getCursorY() > 0) {
      gui.setCursorY(gui.getCursorY() - 1);
    }
  }
}

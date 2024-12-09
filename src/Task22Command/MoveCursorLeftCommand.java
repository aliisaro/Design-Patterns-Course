package Task22Command;

public class MoveCursorLeftCommand implements Command {
  private final MainGUI gui;

  public MoveCursorLeftCommand(MainGUI gui) {
    this.gui = gui;
  }

  @Override
  public void execute() {
    if (gui.getCursorX() > 0) {
      gui.setCursorX(gui.getCursorX() - 1);
    }
  }
}

package Task22Command;

public class MoveCursorRightCommand implements Command {
  private final MainGUI gui;

  public MoveCursorRightCommand(MainGUI gui) {
    this.gui = gui;
  }

  @Override
  public void execute() {
    if (gui.getCursorX() < gui.getGridSize() - 1) {
      gui.setCursorX(gui.getCursorX() + 1);
    }
  }
}

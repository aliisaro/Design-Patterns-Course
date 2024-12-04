package Task22Command;

public class GenerateCodeCommand implements Command {
  private final boolean[][] grid;

  public GenerateCodeCommand(boolean[][] grid) {
    this.grid = grid;
  }

  @Override
  public void execute() {
    StringBuilder code = new StringBuilder("int[][] pixelArt = {\n");
    for (int y = 0; y < grid.length; y++) {
      code.append("    {");
      for (int x = 0; x < grid[y].length; x++) {
        code.append(grid[y][x] ? "1" : "0");
        if (x < grid[y].length - 1) {
          code.append(", ");
        }
      }
      code.append("}");
      if (y < grid.length - 1) {
        code.append(",");
      }
      code.append("\n");
    }
    code.append("};");
    System.out.println(code.toString());
  }
}

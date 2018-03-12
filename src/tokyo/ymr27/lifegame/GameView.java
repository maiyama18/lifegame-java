package tokyo.ymr27.lifegame;

public class GameView {
  private static final String ALIVE_CODE = "\u001B[31;100m";
  private static final String DEAD_CODE = "\u001B[37;100m";
  private static final String RESET_CODE = "\u001B[0m";
  private static final char CELL_CHAR = '*';

  private int numRows;
  private int numCols;

  GameView(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;
  }

  public void printField(GameField gameField, int duration_ms) {
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        boolean isAlive = gameField.isCellAlive(row, col);
        printCell(isAlive);
      }
      System.out.println();
    }
    System.out.println();

    try {
      Thread.sleep(duration_ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void printCell(boolean isAlive) {
    String code = isAlive ? ALIVE_CODE : DEAD_CODE;

    System.out.print(code);
    System.out.print(CELL_CHAR);
    System.out.print(RESET_CODE);
  }
}

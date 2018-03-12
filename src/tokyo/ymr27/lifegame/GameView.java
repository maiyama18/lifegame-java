package tokyo.ymr27.lifegame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameView {
  private static final Map<String, String> COLORS;
  private static final Object[] COLOR_VALUES;
  private static final Random GENERATOR;

  static {
    COLORS = new HashMap<String, String>();
    COLORS.put("ANSI_RESET" , "\u001B[0m");
    COLORS.put("ANSI_BLACK" , "\u001B[30m");
    COLORS.put("ANSI_RED" , "\u001B[31m");
    COLORS.put("ANSI_GREEN" , "\u001B[32m");
    COLORS.put("ANSI_YELLOW" , "\u001B[33m");
    COLORS.put("ANSI_BLUE" , "\u001B[34m");
    COLORS.put("ANSI_PURPLE" , "\u001B[35m");
    COLORS.put("ANSI_CYAN" , "\u001B[36m");
    COLORS.put("ANSI_WHITE" , "\u001B[37m");

    COLOR_VALUES = COLORS.values().toArray();

    GENERATOR = new Random();
  }

  private int numRows;
  private int numCols;

  public GameView(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;
  }

  public void printField(GameField gameField, int duration_ms) {
    System.out.print(ramdomColorCode());
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        char c = gameField.isCellAlive(row, col) ? '*' : ' ';
        System.out.print(c);
      }
      System.out.println();
    }
    System.out.println(COLORS.get("ANSI_RESET"));

    try {
      Thread.sleep(duration_ms);
    } catch (InterruptedException e) {}
  }

  private String ramdomColorCode() {
    return (String) COLOR_VALUES[GENERATOR.nextInt(COLOR_VALUES.length)];
  }
}

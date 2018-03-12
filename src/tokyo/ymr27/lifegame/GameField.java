package tokyo.ymr27.lifegame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameField {
  private final int numRows;
  private final int numCols;
  private boolean[][] data;

  GameField(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;

    initializeData();
  }

  public GameField evolve() {
    boolean[][] nextData = new boolean[numRows][numCols];

    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        int numNeighborsAlive = getNumNeighborsAlive(row, col);
        nextData[row][col] = getNextState(data[row][col], numNeighborsAlive);
      }
    }

    data = nextData;
    return this;
  }

  public boolean isCellAlive(int row, int col) {
    return data[row][col];
  }


  private void initializeData() {
    Random generator = new Random();

    data = new boolean[numRows][numCols];
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        data[row][col] = generator.nextBoolean();
      }
    }
  }

  private int getNumNeighborsAlive(int row, int col) {
    int upRow = (row == 0) ? numRows - 1 : row - 1;
    int downRow = (row == numRows - 1) ? 0 : row + 1;
    int leftCol = (col == 0) ? numCols - 1 : col - 1;
    int rightCol = (col == numCols - 1) ? 0 : col + 1;

    List<Boolean> isNeighborsAlive = Arrays.asList(
            data[upRow][col],
            data[upRow][rightCol],
            data[row][rightCol],
            data[downRow][rightCol],
            data[downRow][col],
            data[downRow][leftCol],
            data[row][leftCol],
            data[upRow][leftCol]
    );

    return (int) isNeighborsAlive.stream().filter(b -> b).count();
  }

  private boolean getNextState(boolean prevState, int numNeighborsAlive) {
    if (prevState) {
      switch (numNeighborsAlive) {
        case 0:
        case 1:
          return false;
        case 2:
        case 3:
          return true;
        default:
          return false;
      }
    } else {
      switch (numNeighborsAlive) {
        case 3:
          return true;
        default:
          return false;
      }
    }
  }
}

package tokyo.ymr27.lifegame;

public class GameApp {
  private final int numRows;
  private final int numCols;
  private final GameController gameController;

  public GameApp(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;

    GameField gameField = new GameField(numRows, numCols);
    GameView gameView = new GameView(numRows, numCols);
    gameController = new GameController(gameField, gameView);
  }

  public void start() {
    gameController.start();
  }
}

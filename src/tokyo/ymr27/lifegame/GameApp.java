package tokyo.ymr27.lifegame;

public class GameApp {
  private final GameController gameController;

  GameApp(int numRows, int numCols) {
    GameField gameField = new GameField(numRows, numCols);
    GameView gameView = new GameView(numRows, numCols);
    gameController = new GameController(gameField, gameView);
  }

  public void start() {
    gameController.start();
  }
}

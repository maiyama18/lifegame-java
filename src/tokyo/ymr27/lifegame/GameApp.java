package tokyo.ymr27.lifegame;

public class GameApp {
  private final GameController gameController;

  GameApp(int size) {
    GameField gameField = new GameField(size, size);
    GameView gameView = new GameView(size, size);
    gameController = new GameController(gameField, gameView);
  }

  public void start() {
    gameController.start();
  }
}

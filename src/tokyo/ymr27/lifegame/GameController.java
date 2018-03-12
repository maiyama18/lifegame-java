package tokyo.ymr27.lifegame;

public class GameController {
  private GameField gameField;
  private final GameView gameView;

  GameController(GameField gameField, GameView gameView) {
    this.gameField = gameField;
    this.gameView = gameView;
  }

  @SuppressWarnings("InfiniteLoopStatement")
  public void start() {
    while (true) {
      gameView.printField(gameField, 1000);
      gameField = gameField.evolve();
    }
  }
}

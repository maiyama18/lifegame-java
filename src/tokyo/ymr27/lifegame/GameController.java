package tokyo.ymr27.lifegame;

public class GameController {
  private GameField gameField;
  private final GameView gameView;

  public GameController(GameField gameField, GameView gameView) {
    this.gameField = gameField;
    this.gameView = gameView;
  }

  public void start() {
    while (true) {
      gameView.printField(gameField, 1000);
      gameField = gameField.evolve();
    }
  }
}

package tokyo.ymr27.lifegame;

public class Main {
    public static void main(String[] args) {
      int size;
      if (args.length < 1) {
        size = 14;
      } else {
        size = Integer.valueOf(args[0]);
      }

      new GameApp(size).start();
    }
}

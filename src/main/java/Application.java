import calculator.Calculator;
import calculator.UnsupportedNegativeNumberException;
import cli.CliManager;

public class Application {
  public static void main(String[] args) throws UnsupportedNegativeNumberException {
    CliManager inputManager = new CliManager();
    inputManager.runAdd();
  }
}

package cli;

import calculator.Calculator;
import calculator.UnsupportedNegativeNumberException;

import java.util.Scanner;

public class CliManager {
  private Calculator calculator;

  public CliManager() {
    this.calculator = new Calculator();
  }

  public void runAdd() {
    System.out.print("Please insert sum expression and press enter: ");
    Scanner scanner = new Scanner(System.in);
    String expression = scanner.nextLine();
    try {
      int result = calculator.sum(expression);
      System.out.printf("Result: %d\n", result);
    } catch (UnsupportedNegativeNumberException e) {
      System.out.printf("ERROR: %s\n", e.getMessage());
    }
    runAdd();
  }
}

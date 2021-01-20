package calculator;

import java.util.List;

public class UnsupportedNegativeNumberException extends Exception {
  public UnsupportedNegativeNumberException(List<Integer> negativeNumbers) {
    super(generateMessage(negativeNumbers));
  }

  private static String generateMessage(List<Integer> negativeNumbers) {
    StringBuilder builder = new StringBuilder();
    builder.append("Negatives not allowed: Negative numbers provided: [");

    negativeNumbers.forEach((number) -> {
      builder.append(number).append(",");
    });

    builder.deleteCharAt(builder.length() - 1);
    builder.append("]");

    return builder.toString();
  }
}

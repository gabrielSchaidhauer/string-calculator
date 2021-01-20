package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  /**
   * Sum all numbers based on a given expression using ',' as delimiter:
   * 1,2,3 = 6
   *
   * Also the expression can be delimited by a custom delimiter
   * specified on the beginning of the expression by in the current format
   * \\[delimiter]\n1[delimiter]2[delimiter]3
   *
   * Multiple delimiters can be used separated by a comma:
   *
   * //*,%\n1*2%3%4*5
   *
   * Also delimiters can have variable width:
   *
   * //***\n1***2***3
   *
   * the options above can be combined.
   *
   * @param termsExpression The expression used for the sum.
   * @return The sum result in integer format.
   * @throws UnsupportedNegativeNumberException in case there is one or more negative numbers.
   */
  public int sum(String termsExpression) throws UnsupportedNegativeNumberException {
    String[] terms = findTerms(termsExpression);
    List<Integer> negativeNumbers = new ArrayList<>();

    int sum = 0;
    for (String term : terms) {
      if (!term.isEmpty()) {
        int number = Integer.parseInt(term);
        if (number < 0) {
          negativeNumbers.add(number);
        } else if (number <= 1000) {
          sum += Integer.parseInt(term);
        }
      }
    }

    if (negativeNumbers.isEmpty()) {
      return sum;
    } else {
      throw new UnsupportedNegativeNumberException(negativeNumbers);
    }
  }

  /**
   * Process and sanitize the expression to find the terms to be used by the operations.
   * Depending on the expression structure it may contain empty strings as terms that should be
   * handled by the operation implementation.
   *
   * @param termsExpression The expression defining the sum.
   * @return The sanitized terms.
   */
  private String[] findTerms(String termsExpression) {
    Matcher delimiterMatcher = Pattern.compile("//(.*?)\\\\n").matcher(termsExpression);
    String sanitizationExpression = termsExpression;

    if (delimiterMatcher.find()) {
      String delimiterGroup = delimiterMatcher.group(1);
      String[] delimiters = delimiterGroup.split(",");
      for (String customDelimiter : delimiters) {
        sanitizationExpression = sanitizationExpression.replaceAll(Pattern.quote(customDelimiter), ",");
      }
    }
    sanitizationExpression = sanitizationExpression.replaceAll("[^0-9-,]", "");
    return sanitizationExpression.split(",");
  }
}

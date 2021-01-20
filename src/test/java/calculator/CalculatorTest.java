package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorTest {

  @Test
  public void simpleSumTest() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("1,2,5");
    Assertions.assertEquals(8, result);
  }

  @Test
  public void simpleSumWithTwoDigitsNumberTest() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("10,2,5");
    Assertions.assertEquals(17, result);
  }

  @Test
  public void sumWithNoTerms() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("");
    Assertions.assertEquals(0, result);
  }

  @Test
  public void sumWithOnlyCommas() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum(",,,");
    Assertions.assertEquals(0, result);
  }

  @Test
  public void sumWithMissingTerms() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum(",,5,");
    Assertions.assertEquals(5, result);
  }

  @Test
  public void sumWithNewLineAfterTerm() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("1\\n,2,3");
    Assertions.assertEquals(6, result);
  }

  @Test
  public void sumWithNewLineBeforeTerm() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("1,\\n2,4");
    Assertions.assertEquals(7, result);
  }

  @Test
  public void sumWithCustomDelimiters() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int resultSemicolon = calculatorOperation.sum("//;\\n1;3;4");
    int resultDollar = calculatorOperation.sum("//$\\n1$2$3");
    int resultAtSign = calculatorOperation.sum("//@\\n2@3@8");
    Assertions.assertEquals(8, resultSemicolon);
    Assertions.assertEquals(6, resultDollar);
    Assertions.assertEquals(13, resultAtSign);
  }

  @Test
  public void sumWithNegativeNumber() {
    Calculator calculatorOperation = new Calculator();
    UnsupportedNegativeNumberException thrown = Assertions.assertThrows(UnsupportedNegativeNumberException.class,
        () -> calculatorOperation.sum("1,\\n-2,4"));
    Assertions.assertEquals("Negatives not allowed: Negative numbers provided: [-2]", thrown.getMessage());
  }

  @Test
  public void sumWithTwoNegativeNumbers() {
    Calculator calculatorOperation = new Calculator();
    UnsupportedNegativeNumberException thrown = Assertions.assertThrows(UnsupportedNegativeNumberException.class,
        () -> calculatorOperation.sum("-1,\\n-2,4"));

    Assertions.assertEquals("Negatives not allowed: Negative numbers provided: [-1,-2]", thrown.getMessage());
  }

  @Test
  public void sumWithNumberLargerThan1000() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("1,\\n2,4, 1001");
    Assertions.assertEquals(7, result);
  }

  @Test
  public void sumWithNumberEqualTo1000() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("1,\\n2,4, 1000");
    Assertions.assertEquals(1007, result);
  }

  @Test
  public void sumWithDelimiterArbitraryLength() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("//***\\n1***2***3");
    Assertions.assertEquals(6, result);
  }

  @Test
  public void sumWithMultipleDelimiters() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("//$,@\\n1$2@3");
    Assertions.assertEquals(6, result);
  }

  @Test
  public void sumWithMultipleDelimitersOfArbitraryLenght() throws UnsupportedNegativeNumberException {
    Calculator calculatorOperation = new Calculator();
    int result = calculatorOperation.sum("//$,***\\n1*$2***3");
    Assertions.assertEquals(6, result);
  }
}
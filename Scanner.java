import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.lang.model.util.ElementScanner6;

public class Scanner {

  private char peek;
  private static char[] operands = { '+', '-', '*', '/', '<', '>' };
  private static Set operandSet = new HashSet<>(Arrays.asList(operands));

  enum TokenType {
    NUM, PLUS, MINUS, MUL, DIV, LT, LTE, GT, GTE;
  }

  class Token {
    TokenType tokenType;
    String tokenVal;

    public Token(TokenType tokenType, String tokenVal) {
      this.tokenType = tokenType;
      this.tokenVal = tokenVal;
    }

    public String toString() {
      return this.tokenType + ": " + this.tokenVal + " ";
    }
  }

  private void readChar(StringBuilder stream) {
    if (stream.length() != 0) {
      this.peek = stream.charAt(0);
      stream.deleteCharAt(0);
    }
  }

  private boolean peekIsOperand() {
    return operandsSet.contains(this.peek);
  }

  private void advancePastState0(StringBuilder stream) {
    for (;; readChar(stream)) {
      if (this.peek == ' ')
        continue;
      else if (this.peek == '\t')
        continue;
      else if (this.peek == '\n')
        continue;
      else if (stream.length() == 0)
        break;
      else
        break;
    }
  }

  private Token advancePastState1(StringBuilder stream) {
    StringBuilder v = new StringBuilder(String.valueOf(peek));
    while (stream.length() != 0) {
      readChar(stream);
      if (!Character.isDigit(this.peek))
        break;
      v.append(String.valueOf(this.peek));
    }
    return new Token(TokenType.NUM, v.toString());
  }

  private Token advancePastState2(StringBuilder stream) {
    return null;
  }

  public Token extractToken(StringBuilder stream) {
    /* TODO #2: Extract the next token in the string, or report an error */
    this.peek = ' ';
    advancePastState0(stream);
    Token tok;
    if(Character.isDigit(this.peek))
      Token tok = advancePastState1(stream);
    else if(peekIsOperand())
      Token tok = advancePastState2(stream);
    return tok;
  }

  public String extractTokens(String arg) {
    String result = "";
    StringBuilder stream = new StringBuilder(arg);
    while (!arg.isEmpty()) {
      Token nextToken = extractToken(stream);
      result += nextToken.toString();
    }
    return result;
  }

}

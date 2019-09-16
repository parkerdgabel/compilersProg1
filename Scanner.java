import javax.lang.model.util.ElementScanner6;

public class Scanner{
  enum TokenType{
      NUM, PLUS, MINUS, MUL, DIV, LT, LTE, GT, GTE;
  }

  class Token{
    TokenType tokenType;
    String tokenVal;
    public Token(TokenType tokenType, String tokenVal){
      this.tokenType = tokenType;
      this.tokenVal = tokenVal;
    }
    public String toString(){
      return this.tokenType + ": " + this.tokenVal + " ";
    }
  }

  private static void readChar(char peek, StringBuilder stream) {
    peek = stream.charAt(0);
    stream = stream.deleteCharAt(0);
  }

  private static void advancePastState0(char peek, StringBuilder stream) {
    for (; ; readChar(peek, stream)) {
      if (peek == ' ')
        continue;
      else if (peek == '\t')
        continue;
      else if (peek == '\n')
        continue;
      else
        break;
    }
  }
  public Token extractToken(StringBuilder stream){
    /* TODO #2: Extract the next token in the string, or report an error*/
    char peek = ' ';
    advancePastState0(peek, stream);
    return null;
  }

  public String extractTokens(String arg){
    /* TODO #1: Finish this function to iterate over all tokens in the input string.

       Pseudo code:
       String extractTokens(String arg):
         String result= “”;
         while(arg is not empty)
            Token nextToken = extractToken(arg)
            result += nextToken.toString()
         return result
    */
    String result = "";
    StringBuilder stream = new StringBuilder(arg);
    while (!arg.isEmpty()) {
      Token nextToken = extractToken(stream);
      result += nextToken.toString();
    }
    return result;
  }

}

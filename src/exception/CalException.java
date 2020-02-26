package exception;
import grammar.Token;

public class CalException {

    public static class LexException extends RuntimeException {
        public LexException(char curChar, int position) {
            super("Invalid token found: " + curChar + "     Found at position: " + position);
        }
    }

    public static class TokenException extends RuntimeException {
        public <T> TokenException(T value, Token type) {
            super("Invalid token created, value: " + value
                    + ", given value type: " + value.getClass() + ", required type: " + type);
        }
    }

    public static class ParserException extends RuntimeException {
        public ParserException(String error) {

            super(error);
        }
    }


}
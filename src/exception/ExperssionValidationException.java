package exception;

 class ExpressionValidationException  extends RuntimeException {
        public ExpressionValidationException(char curChar, int position) {
            super("Invalid token found: " + curChar + "     Found at position: " + position);
        }
    }


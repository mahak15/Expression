
import grammar.*;
import java.util.*;


public class Controller {

    String expression;

    Controller(String exp) {

        this.expression = exp;
    }

    public Double control() {
        Lexer lex = new Lexer(expression + "\0");
        lex.tokenize();

        ArrayList<Token> token_list = lex.getTokenized();
        token_list.add(new Token("EOF", "EOF"));
        for (Token token : token_list) {
            System.out.println(token.tokToString() + " ");
        }

        Parser parse = new Parser(token_list);
        System.out.println(parse.isValid());
        System.out.println(parse.getAST());
        parse.printAST();
        return parse.getValue();

    }
}
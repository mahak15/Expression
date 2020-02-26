
import Evaluation.ExpressionTree;
import Evaluation.Node;
import Evaluation.PostfixToken;
import grammar.Lexer;

import grammar.Parser;
import grammar.Token;

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
        ArrayList<String> postString = new ArrayList<>();
        token_list.add(new Token("EOF", "EOF"));
        for (Token token : token_list) {
            System.out.println(token.tokToString() + " ");
        }

        Parser parseTree = new Parser(token_list);
        if (parseTree.isValid()) {
            PostfixToken pt = new PostfixToken();
            ArrayList<Token> list = pt.convertInfixToPostfix(token_list);
            for(Token token:list) {
                if(token.getValue()=="EOF")
                    break;
                postString.add(token.getValue());
            }
            ExpressionTree et = new ExpressionTree();
           Node root=et.constructTree(postString);

        } else {
            System.out.println("Please enter valid string of expression.");
        }


        return 0.0;
    }
}
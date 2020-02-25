import grammar.Lexer;

import grammar.Parser;
import grammar.Token;

import java.util.*;


public class Controller {

    String expression;

    Controller(String exp) {
        this.expression = exp;
    }

    public String control() {
        Lexer lex = new Lexer(expression + "\0");
        lex.tokenize();
        ArrayList<Token> token_list = lex.getTokenized();
        token_list.add(new Token("EOF", "EOF"));
        for (Token token : token_list) {
            System.out.println(token.tokToString() + " ");
        }

        Parser parseTree = new Parser(token_list);
        System.out.println(parseTree.isValid());
        return "";
    }
}




      /*  boolean isValid = getValidity(parseTree);

        if(isValid){
            String result = getResult(parseTree);
            return result;

        }else{
            System.out.println("Wrong String");//Throw Exceptions.

        }

    }


    Boolean getValidity(   Parser parseTree){
        Validation v=new Validation();
        boolean valid=v.validate(parseTree);
        return valid;
    }
   String getResult(Node parseTree)
    {
        // String result=new Evaluation(expression);
        //  return result;
    }*/


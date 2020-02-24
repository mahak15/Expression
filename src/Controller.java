import grammar.Lexer;
import grammar.Node;
import grammar.Parser;
import grammar.Token;

import java.util.*;


public class Controller {

    String expression;

    Controller(String exp)
    {
        this.expression=exp;
    }
    public String controller( ) {
        Lexer lex = new Lexer(expression + '\0');
        lex.tokenize();

        ArrayList<Token> token_list = lex.getTokenized();
        for (int i = 0; i < token_list.size(); i++) {
            System.out.println(token_list.get(i).tokToString());
        }

     /*   Parser parseTree = new Parser(token_list,expression+'\0');
        boolean isValid = getValidity(parseTree);

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

     return "";
    }
}

package Evaluation;
import grammar.Token;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class PostfixToken {
    ArrayList<Token> tokens;
   // private Token token;
    Queue<Token> queue = new LinkedList<>();
    static int Prec(Token ch) {
        if (ch.tokCheckType("Operators")) {
            switch (ch.getValue()) {
                case "+":
                case "-":
                    return 2;
                case "*":
                case "/":
                    return 1 ;
                case "^":
                case"sin":
                case"cos":
                case"tan":

            }
        }
        return -1;
    }
  //  public PostfixToken(ArrayList<Token> tokens)  {
     //   this.tokens = tokens;
    //}
    public ArrayList<Token> convertInfixToPostfix(ArrayList<Token> tokens) {
        ArrayList<Token> postfixTokens = new ArrayList<>();
        Stack<Token> stack = new Stack<Token>();

        for (Token token : tokens) {
            if (token.getType() == "operand") {
                postfixTokens.add(token);
            } else if (token.tokCheckVal("(")) {
                stack.push(token);
            } else if (token.getType()==")") {
                if (stack.isEmpty()) {
                    System.out.println("Invalid");
                } else {
                    while (true) {
                        Token t=stack.peek();
                        if(t.getType()==")"||t.getType()=="(") {
                            if (!stack.isEmpty() && token.getType() != "(") {
                                stack.pop();
                            } else {
                                stack.pop();
                                break;
                            }
                        }
                        else{
                            postfixTokens.add(stack.pop());
                        }
                    }
                    if (!stack.empty()) {
                        Token t=stack.peek();
                        if (t.getType()==")"||t.getType()=="(") {
                            if (t.getType() != ")") {
                                stack.pop();
                            }
                        }
                    }
                }
            }
        else // an operator is encountered
        {

            while (!stack.isEmpty() && Prec(token) <= Prec(stack.peek())) {
                Token t=stack.peek();
                if (t.getType()==")"||t.getType()=="(")
                    if (t.getType() == ")")
                        System.out.println("error");
                postfixTokens.add(stack.pop());
            }
            stack.push(token);
        }
    }

            while (!stack.isEmpty()) {
                Token t=stack.peek();
        if (t.getType()==")"||t.getType()=="(") {
            if (t.getType()==")")
                System.out.println("Invalid expression");
        }
        postfixTokens.add(stack.pop());
        postfixTokens.removeIf(op -> t.getType()==")"||t.getType()=="(");
    }

            return postfixTokens;
}
    }





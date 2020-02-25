package grammar;
import java.util.*;
public class Parser
{
    ArrayList<Token> token_list;
    int tokenPointer;
    Token current_token;

    Token nextToken(){
        tokenPointer++;
        return token_list.get(tokenPointer);
    }


    Boolean factor(){
        Boolean result = true;
        if(current_token.tokCheckVal("(")){
            current_token = nextToken();
            if(expr() == false)
                result = false;
            else if(current_token.tokCheckVal(")") == false){
                System.out.println(") expected -- syntax error");
                result = false;
            }
            else
                current_token = nextToken();
        }
        else if(current_token.tokCheckVal("sin")){
            current_token = nextToken();
            if(current_token.tokCheckVal("(")){
                current_token = nextToken();
                if(expr() == false)
                    result = false;
                else if(current_token.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    current_token = nextToken();
            }
            else
                result=false;

        }
        else if(current_token.tokCheckVal("cos")){
            current_token = nextToken();
            if(current_token.tokCheckVal("(")){
                current_token = nextToken();
                if(expr() == false)
                    result = false;
                else if(current_token.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    current_token = nextToken();
            }
            result=false;
        }
        else if(current_token.tokCheckVal("tan")){
            current_token = nextToken();
            if(current_token.tokCheckVal("(")){
                current_token = nextToken();
                if(expr() == false)
                    result = false;
                else if(current_token.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    current_token = nextToken();
            }
        }
        else if(current_token.tokCheckVal("log")){
            current_token = nextToken();
            if(current_token.tokCheckVal("(")){
                current_token = nextToken();
                if(expr() == false)
                    result = false;
                else if(current_token.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    current_token = nextToken();
            }
            result=false;

        }
        else if (current_token.tokCheckType("operand"))
            current_token = nextToken();
        else {
            System.out.println("Syntax Error !");
            result = false;
        }
        return result;
    }

    Boolean tprime(){
        Boolean result = true;
        if(current_token.tokCheckVal("*")){
            current_token = nextToken();
            if (factor() == false)
                result = false;
            else if (tprime() == false)
                result = false;
        }
        else if(current_token.tokCheckVal("/")){
            current_token = nextToken();
            if (factor() == false)
                result = false;
            else if (tprime() == false)
                result = false;
        }
        else
            result = true;
        return result;
    }

    Boolean term(){
        Boolean result = true;
        if(factor() == false)
            result = false;
        else if (tprime() == false)
            result = false;
        return result;
    }

    Boolean eprime(){
        Boolean result = true;
        if(current_token.tokCheckVal("+")){
            current_token = nextToken();
            if(term() == false)
                result = false;
            else if(eprime() == false)
                result = false;
        }
        else if(current_token.tokCheckVal("-")){
            current_token = nextToken();
            if(term() == false)
                result = false;
            else if(eprime() == false)
                result = false;
        }
        else
            result = true;

        return  result;
    }

    Boolean expr(){
        Boolean result = true;
        if (term() == false)
            result = false;
        else if (eprime() == false)
            result = false;
        return  result;
    }

    public Boolean isValid(){
        current_token = nextToken();
        if(expr() != false)
            return true;
        else
            return false;
    }

    public Parser(ArrayList<Token> list){
        token_list = list;
        tokenPointer = -1;
        current_token = new Token("p","p");
    }

}




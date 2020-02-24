package grammar;

import java.util.*;


public class Lexer extends Letters{
    String experssion;
    ArrayList<Token> token_list;
    String word="";
    Letters tr;
    enum State {
        A,B,C,D
    };




    public void tokenize(){


        char exp[] = experssion.toCharArray();
        char ch = '\0';
        State st = State.A;
        String token = new String();

        for (int i=0; i < exp.length; i++ ) {
            ch = exp[i];
            switch(st){
                case A:
                    if(tr.getType(ch) == "Number"){
                        token += word;
                        if(trigoFunction.contains(word))
                            token_list.add(new Token("operator", token));
                        word="";
                        token = " ";
                        token += ch;
                        st = State.B;
                    }

                    else if(tr.getType(ch) == "Operators"){
                        token += ch;
                        st = State.C;
                    }
                    else if(tr.getType(ch)== "Character"){
                        word+=ch;
                        st=State.A;


                    }
                    else {
                        //throw error
                        System.out.println("invalid literal !");
                    }
                    break;
                case B: if(tr.getType(ch) == "Number"){
                    token += ch;
                    st = State.B;
                }
                else if (tr.getType(ch) == "Operators"){
                    token_list.add(new Token("operand",token));
                    token = "";
                    token += ch;
                    st = State.C;
                }
                else if (tr.getType(ch) == "Symbol"){
                    token += ch;
                    st = State.D;
                }
                else if(ch == '\0') {
                    token_list.add(new Token("operand",token));
                    st = State.A;
                }
                else {
                    //throw error
                    System.out.println("invalid literal");
                }
                    break;
                case C: if (tr.getType(ch) == "Number"){
                    token += word;
                    word="";
                        token_list.add(new Token("operator", token));

                    token = "";
                    token += ch;
                    st = State.B;
                }
                else if(tr.getType(ch)== "Character"){
                    if(token!="")
                    token_list.add(new Token("operator",token));
                    token = "";
                    word+=ch;
                    st=State.C;


                }
                else if ( ch == '\0' ){
                    token_list.add(new Token("operator",token));
                    token = "";
                    st = State.A;
                }
                else{
                    //throw error
                    System.out.println("invalid literal");
                }
                    break;
                case D: if (tr.getType(ch) == "Symbol") {
                    //throw error
                    System.out.println("invalid expression");
                    break;
                }
                else if (tr.getType(ch) == "Number") {
                    token += ch;
                    st = State.D;
                }
                else if(tr.getType(ch) == "Operators") {
                    token_list.add(new Token("operand",token));
                    token = "";
                    token += ch;
                    st = State.C;
                }
                else if ( ch == '\0' ) {
                    token_list.add(new Token("operand", token));
                    token = "";
                    st = State.A;
                }
                else {
                    System.out.println("Invalid");
                }
                    break;
                default:
                    System.out.println("Wrong State");
                    break;
            }
        }
    }
    public  Lexer(String exp) {
        experssion = exp;
        token_list = new ArrayList<Token>();
        tr = new Letters();
    }
    public ArrayList<Token> getTokenized(){
        return token_list;
    }
}

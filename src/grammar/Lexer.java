

package grammar;
import java.util.*;

public class Lexer {
    String expression;
    char[] exparray;
    ArrayList<Token> tokenized;
    Letters tr;
    Set<Character> at;

    int pointer;

    enum opState{
        OPw // 1,2,3
        ,OPd
        ,accept
    };
    Token operand() {
        Token operand = new Token("operand","");
        operand.buildToken(exparray[pointer-1]);

        opState opSt = opState.OPw;
        while (true) {

            switch(opSt){
                case OPw:   if (tr.getType(exparray[pointer]).equals("Number")){
                    opSt = opState.OPw;
                    operand.buildToken(exparray[pointer]);
                    pointer++;
                }
                else if (exparray[pointer] == '.'){
                    opSt = opState.OPd;
                    operand.buildToken(exparray[pointer]);
                    pointer++;
                }
                else opSt = opState.accept;
                    break;

                case OPd:   if (tr.getType(exparray[pointer]).equals("Number")){
                    opSt = opState.OPd;
                    operand.buildToken(exparray[pointer]);
                    pointer++;
                }
                else if (exparray[pointer] == '.'){
                    System.out.println("decimal syntax error");
                    System.exit(0);
                }
                else opSt = opState.accept;
                    break;

                case accept:    return operand;


            }
        }
    }

    enum PlState{
        Pl,accept
    };
    Token leftParen() {
        Token brak = new Token("leftParenthesis","");
        brak.buildToken(exparray[pointer-1]);
        PlState lbr = PlState.Pl;
        while(true){
            switch(lbr){
                case Pl:  if(exparray[pointer] == ')'){
                    System.out.println("Error empty parenthesis");
                    System.exit(0);
                }
                else
                    lbr = PlState.accept;

                case accept:
                    return brak;
            }
        }
    }

    enum PrState{
        Pr,accept
    };
    Token rightParen() {
        Token brak = new Token("rightParenthesis","");
        brak.buildToken(exparray[pointer-1]);
        PrState rbr = PrState.Pr;
        while(true){
            switch(rbr){
                case Pr:  if(exparray[pointer] == '('){
                    System.out.println("Error operator required");
                    System.exit(0);
                }
                else
                    rbr = PrState.accept;

                case accept:
                    return brak;
            }
        }
    }

    enum plusState{
        plus,accept;
    };
    Token plus() {
        Token pl = new Token("operator","");
        pl.buildToken(exparray[pointer-1]);
        plusState plt = plusState.plus;
        while (true) {
            switch(plt){
                case plus:  plt = plusState.accept;
                    break;
                case accept: return pl;
            }
        }
    }

    enum minusState{
        minus,accept
    };
    Token minus() {
        Token pl = new Token("operator","");
        pl.buildToken(exparray[pointer-1]);
        minusState plt = minusState.minus;
        while (true) {
            switch(plt){
                case minus:  plt = minusState.accept;
                    break;
                case accept: return pl;
            }
        }
    }

    enum mulState{
        mul,accept
    };
    Token mul() {
        Token pl = new Token("operator","");
        pl.buildToken(exparray[pointer-1]);
        mulState plt = mulState.mul;
        while (true) {
            switch(plt){
                case mul:  plt = mulState.accept;
                    break;
                case accept: return pl;
            }
        }
    }

    enum divState{
        div,accept
    };
    Token div() {
        Token pl = new Token("operator","");
        pl.buildToken(exparray[pointer-1]);
        divState plt = divState.div;
        while (true) {
            switch(plt){
                case div:  plt = divState.accept;
                    break;
                case accept: return pl;
            }
        }
    }

    enum sinState{
        s1,i,n1,accept
    };
    Token sin(){
        Token sine = new Token("trigonometric","");
        sine.buildToken(exparray[pointer-1]);
        sinState st = sinState.s1;
        while(true) {
            switch(st){
                case s1: if(exparray[pointer] == 'i') {
                    sine.buildToken('i');
                    pointer++;
                    st = sinState.i;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case i: if(exparray[pointer] == 'n') {
                    sine.buildToken('n');
                    pointer++;
                    st = sinState.n1;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case n1: st = sinState.accept;
                    break;
                case accept: return sine;
            }
        }

    }

    enum cosState{
        c,o1,s2,accept
    };
    Token cos(){
        Token cosine = new Token("trigonometric","");
        cosine.buildToken(exparray[pointer-1]);
        cosState st = cosState.c;
        while(true) {
            switch(st){
                case c: if(exparray[pointer] == 'o') {
                    cosine.buildToken('o');
                    pointer++;
                    st = cosState.o1;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case o1: if(exparray[pointer] == 's') {
                    cosine.buildToken('s');
                    pointer++;
                    st = cosState.s2;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case s2: st = cosState.accept;
                    break;
                case accept: return cosine;
            }
        }

    }

    enum tanState{
        t,a,n2,accept
    };
    Token tan(){
        Token tangent = new Token("trigonometric","");
        tangent.buildToken(exparray[pointer-1]);
        tanState st = tanState.t;
        while(true) {
            switch(st){
                case t: if(exparray[pointer] == 'a') {
                    tangent.buildToken('a');
                    pointer++;
                    st = tanState.a;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case a: if(exparray[pointer] == 'n') {
                    tangent.buildToken('n');
                    pointer++;
                    st = tanState.n2;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case n2: st = tanState.accept;
                    break;
                case accept: return tangent;
            }
        }

    }

    enum logState{
        l,o2,g,accept
    };
    Token log(){
        Token loggo = new Token("logarithmic","");
        loggo.buildToken(exparray[pointer-1]);
        logState st = logState.l;
        while(true) {
            switch(st){
                case l: if(exparray[pointer] == 'o') {
                    loggo.buildToken('o');
                    pointer++;
                    st = logState.o2;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case o2: if(exparray[pointer] == 'g') {
                    loggo.buildToken('g');
                    pointer++;
                    st = logState.g;
                }
                else {
                    System.out.println("unexpexted literal at position: " + pointer);
                    System.exit(0);
                }
                    break;
                case g: st = logState.accept;
                    break;
                case accept: return loggo;
            }
        }

    }



    public  void   tokenize() {
        while (exparray[pointer] != '\0'){
            if (at.contains(exparray[pointer]) || (tr.getType(exparray[pointer]).equals("Number")) ){

                if ( (tr.getType(exparray[pointer]).equals("Number")) ) {
                    pointer++;
                    tokenized.add(operand());
                }
                if( exparray[pointer] == '(' ){
                    pointer++;
                    tokenized.add(leftParen());
                }

                if( exparray[pointer] == ')' ){
                    pointer++;
                    tokenized.add(rightParen());
                }
                if( exparray[pointer] == '+' ){
                    pointer++;
                    tokenized.add(plus());

                    if ( (exparray[pointer] == '-') || (tr.getType(exparray[pointer]).equals("Number")) ) {
                        pointer++;
                        tokenized.add(operand());
                    }
                }

                if( exparray[pointer] == '-' ){
                    pointer++;
                    tokenized.add(minus());

                    if ( (exparray[pointer] == '-') || (tr.getType(exparray[pointer]).equals("Number")) ) {
                        pointer++;
                        tokenized.add(operand());
                    }
                }


                if( exparray[pointer] == '*' ){
                    pointer++;
                    tokenized.add(mul());
                }
                if( exparray[pointer] == '/' ){
                    pointer++;
                    tokenized.add(div());
                }
                if (exparray[pointer] == 's'){
                    pointer++;
                    tokenized.add(sin());
                }
                if (exparray[pointer] == 'c'){
                    pointer++;
                    tokenized.add(cos());
                }
                if (exparray[pointer] == 't'){
                    pointer++;
                    tokenized.add(tan());
                }
                if (exparray[pointer] == 'l'){
                    pointer++;
                    tokenized.add(log());
                }
            }
            else
            {
                System.out.println("Wrong literal !");
                System.exit(0);
            }


        }
    }

    public  Lexer(String exp) {
        expression = exp;
        exparray = expression.toCharArray();
        tokenized = new ArrayList<Token>();
        tr = new Letters();
        pointer = 0;
        at = new HashSet<>(Arrays.asList('+','-','*','/','(',')','s','c','t','l'));
    }

    public ArrayList<Token> getTokenized() {

        return tokenized;
    }

}


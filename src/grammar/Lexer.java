package grammar;
import java.util.*;


public class Lexer  {
    String expression;
    char[] exparray;
    ArrayList<Token> tokenized;
    Letters tr;
    int pointer;

    enum operatorState {
        Operatorword, OperatorDigit, accept
    };

    Token operand() {
        Token opnd = new Token("operand", "");
        opnd.buildToken(exparray[pointer - 1]);

        operatorState opSt = operatorState.Operatorword;
        while (true) {

            switch (opSt) {
                case Operatorword:
                    if (tr.getType(exparray[pointer]).equals("Number")) {
                        opSt = operatorState.Operatorword;
                        opnd.buildToken(exparray[pointer]);
                        pointer++;
                    } else if (exparray[pointer] == '.') {
                        opSt = operatorState.OperatorDigit;
                        opnd.buildToken(exparray[pointer]);
                        pointer++;
                    } else opSt = operatorState.accept;
                    break;

                case OperatorDigit:
                    if (tr.getType(exparray[pointer]).equals("Number")) {
                        opSt = operatorState.OperatorDigit;
                        opnd.buildToken(exparray[pointer]);
                        pointer++;
                    } else if (exparray[pointer] == '.') {
                        System.out.println("decimal syntax error");
                        System.exit(0);
                    } else opSt = operatorState.accept;
                    break;

                case accept:
                    return opnd;


            }
        }
    }

    enum PlState {
        Pl, accept
    }

    ;

    Token leftParen() {
        Token brak = new Token("leftParenthesis", "");
        brak.buildToken(exparray[pointer - 1]);
        PlState lbr = PlState.Pl;
        while (true) {
            switch (lbr) {
                case Pl:
                    if (exparray[pointer] == ')') {
                        System.out.println("Error empty parenthesis");
                        System.exit(0);
                    } else
                        lbr = PlState.accept;

                case accept:
                    return brak;
            }
        }
    }

    enum PrState {
        Pr, accept
    }

    ;

    Token rightParen() {
        Token brak = new Token("rightParenthesis", "");
        brak.buildToken(exparray[pointer - 1]);
        PrState rbr = PrState.Pr;
        while (true) {
            switch (rbr) {
                case Pr:
                    if (exparray[pointer] == '(') {
                        System.out.println("Error operator required");
                        System.exit(0);
                    } else
                        rbr = PrState.accept;

                case accept:
                    return brak;
            }
        }
    }

    enum additionState {
        addition, accept;
    }

    ;

    Token addition() {
        Token pl = new Token("operator", "");
        pl.buildToken(exparray[pointer - 1]);
        additionState plt = additionState.addition;
        while (true) {
            switch (plt) {
                case addition:
                    plt = additionState.accept;
                    break;
                case accept:
                    return pl;
            }
        }
    }

    enum subtractionState {
        subtraction, accept
    }

    ;

    Token subtraction() {
        Token pl = new Token("operator", "");
        pl.buildToken(exparray[pointer - 1]);
        subtractionState plt = subtractionState.subtraction;
        while (true) {
            switch (plt) {
                case subtraction:
                    plt = subtractionState.accept;
                    break;
                case accept:
                    return pl;
            }
        }
    }

    enum multiplicationState {
        multiplication, accept
    }

    ;

    Token multiplication() {
        Token pl = new Token("operator", "");
        pl.buildToken(exparray[pointer - 1]);
        multiplicationState plt = multiplicationState.multiplication;
        while (true) {
            switch (plt) {
                case multiplication:
                    plt = multiplicationState.accept;
                    break;
                case accept:
                    return pl;
            }
        }
    }

    enum divisionState {
        division, accept
    }

    ;

    Token division() {
        Token pl = new Token("operator", "");
        pl.buildToken(exparray[pointer - 1]);
        divisionState plt = divisionState.division;
        while (true) {
            switch (plt) {
                case division:
                    plt = divisionState.accept;
                    break;
                case accept:
                    return pl;
            }
        }
    }

    enum sinState {
        s1, i, n1, accept
    };

    Token sin() {
        Token sine = new Token("trigonometric", "");
        sine.buildToken(exparray[pointer - 1]);
        sinState st = sinState.s1;
        while (true) {
            switch (st) {
                case s1:
                    if (exparray[pointer] == 'i') {
                        sine.buildToken('i');
                        pointer++;
                        st = sinState.i;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case i:
                    if (exparray[pointer] == 'n') {
                        sine.buildToken('n');
                        pointer++;
                        st = sinState.n1;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case n1:
                    st = sinState.accept;
                    break;
                case accept:
                    return sine;
            }
        }

    }

    enum cosState {
        c, o1, s2, accept
    };

    Token cos() {
        Token cosine = new Token("trigonometric", "");
        cosine.buildToken(exparray[pointer - 1]);
        cosState st = cosState.c;
        while (true) {
            switch (st) {
                case c:
                    if (exparray[pointer] == 'o') {
                        cosine.buildToken('o');
                        pointer++;
                        st = cosState.o1;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case o1:
                    if (exparray[pointer] == 's') {
                        cosine.buildToken('s');
                        pointer++;
                        st = cosState.s2;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case s2:
                    st = cosState.accept;
                    break;
                case accept:
                    return cosine;
            }
        }

    }

    enum tanState {
        t, a, n2, accept
    }

    ;

    Token tan() {
        Token tangent = new Token("trigonometric", "");
        tangent.buildToken(exparray[pointer - 1]);
        tanState st = tanState.t;
        while (true) {
            switch (st) {
                case t:
                    if (exparray[pointer] == 'a') {
                        tangent.buildToken('o');
                        pointer++;
                        st = tanState.a;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case a:
                    if (exparray[pointer] == 'n') {
                        tangent.buildToken('n');
                        pointer++;
                        st = tanState.n2;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case n2:
                    st = tanState.accept;
                    break;
                case accept:
                    return tangent;
            }
        }

    }

    enum logState {
        l, o2, g, accept
    }

    ;

    Token log() {
        Token logg = new Token("logarithmic", "");
        logg.buildToken(exparray[pointer - 1]);
        logState st = logState.l;
        while (true) {
            switch (st) {
                case l:
                    if (exparray[pointer] == 'o') {
                        logg.buildToken('o');
                        pointer++;
                        st = logState.o2;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case o2:
                    if (exparray[pointer] == 'g') {
                        logg.buildToken('g');
                        pointer++;
                        st = logState.g;
                    } else {
                        System.out.println("unexpexted literal at position: " + pointer);
                        System.exit(0);
                    }
                    break;
                case g:
                    st = logState.accept;
                    break;
                case accept:
                    return logg;
            }
        }

    }


    public void tokenize() {
        while (exparray[pointer] != '\0') {
           //System.out.println(exparray[pointer]);
            if ((exparray[pointer] == '-') || (tr.getType(exparray[pointer]).equals("Number"))) {
                pointer++;
                tokenized.add(operand());
            }
          // System.out.println(exparray[pointer]);
            if (exparray[pointer] == '(') {
                pointer++;
                tokenized.add(leftParen());
            }

            if (exparray[pointer] == ')') {
                pointer++;
                tokenized.add(rightParen());
            }
            if (exparray[pointer] == '+') {
                pointer++;
                tokenized.add(addition());
            }
            if (exparray[pointer] == '-') {
                pointer++;
                tokenized.add(subtraction());
            }
            if (exparray[pointer] == '*') {
                pointer++;
                tokenized.add(multiplication());
            }
            if (exparray[pointer] == '/') {
                pointer++;
                tokenized.add(division());
            }
            if (exparray[pointer] == 's') {
                pointer++;
                tokenized.add(sin());
            }
            if (exparray[pointer] == 'c') {
                pointer++;
                tokenized.add(cos());
            }
            if (exparray[pointer] == 't') {
                pointer++;
                tokenized.add(tan());
            }
            if (exparray[pointer] == 'l') {
                pointer++;
                tokenized.add(log());
            }

        }
    }

    public Lexer(String str) {
        expression = str;
        exparray = expression.toCharArray();
        tokenized = new ArrayList<Token>();
        tr = new Letters();
        pointer = 0;
    }

    public ArrayList<Token> getTokenized() {
        return tokenized;
    }
}

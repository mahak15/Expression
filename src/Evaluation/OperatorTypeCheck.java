package Evaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OperatorTypeCheck {

    Set<Character> binaryOperator = new HashSet<>(Arrays.asList('+', '-', '/', '*', '^', '%'));
    Set<String > unaryOperator = new HashSet<>(Arrays.asList("sin","cos","tan","log"));
    Set<Character> parenthesis = new HashSet<>(Arrays.asList('(',')'));

    String typeOfOperator(String s) {
        if (binaryOperator.contains(s))
            return "binary";

        else if (unaryOperator.contains(s))
            return "unary";

        else if (parenthesis.contains(s))
            return "p";
return "";
    }
}
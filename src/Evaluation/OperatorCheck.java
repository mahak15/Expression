package Evaluation;

public class OperatorCheck {
    boolean isOperator(String s)
    {
        switch (s)
        {
            case "*":
            case "/":
            case "^":
            case "+":
            case "-":
            case"sin":
            case"cos":
            case"tan":
            case"log":
                return true;

            default:
                return false;
        }
    }
}

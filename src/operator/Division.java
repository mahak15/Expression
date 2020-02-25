package operator;
import exception.CalException;

import java.lang.*;
public class Division extends operator {
    public Division(){
        this.precedence=1;
        this.leftAssociative=true;
    }


    @Override
    public Double Solve(double a, double b) {
        try {
            return (a / b);
        } catch (ArithmeticException e) {
            System.out.println("Dividing by 0");
        }
        return 0.0;
    }


    @Override
    public Double solve(double a) {
        return 0.0;
    }
}


package operator;
import exception.CalException;

import java.lang.*;
public class Division extends operator {


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
    public Double Solve(double a) {
        return 0.0;
    }
}


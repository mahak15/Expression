package operator;


public class Mod extends operator {


    @Override
    public Double Solve(double a, double b) {
        return a%b;
    }

    @Override
    public Double Solve(double a) {
        return 0.0;
    }
}

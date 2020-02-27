package operator;


public class Cos extends operator {


    @Override
    public Double Solve(double a, double b) {
        return 0.0;
    }

    @Override
    public Double Solve(double a) {
        return Math.cos(a);
    }
}

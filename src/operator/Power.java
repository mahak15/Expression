package operator;


public class Power extends operator {



    @Override
    public Double Solve(double a, double b) {
        return Math.pow(a,b);
    }

    @Override
    public Double Solve(double a) {
        return 0.0;
    }
}

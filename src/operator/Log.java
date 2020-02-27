package operator;


public class Log extends operator {


    @Override
    public Double Solve(double a, double b) {
        return 0.0;
    }

    @Override
    public Double Solve(double a) {
        return Math.log(a);
    }
}

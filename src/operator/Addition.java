package operator;


public class Addition extends operator {
    
    @Override
    public Double Solve(double a, double b)
    {
        return a+b;
    }

    @Override
    public Double Solve(double a) {
        return a+1;
    }
}

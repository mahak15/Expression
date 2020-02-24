package operator;


public class Addition extends operator {
    public Addition(){
        this.precedence=2;
        this.leftass=true;
    }


    @Override
    public Double Solve(double a, double b) {
        return a+b;
    }

    @Override
    public Double solve(double a) {
        return a+1;
    }
}

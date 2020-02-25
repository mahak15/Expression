public class Main {

    public static void main(String[] args) {
        Controller c = new Controller(args[0]);
        //String result = c.control();
        Evaluation e=new Evaluation();
        Double result=e.eval();
        printResult(result);
    }
    public static void printResult(Double result)
    {
        System.out.println("Result of given expression is ="+result);
    }


}





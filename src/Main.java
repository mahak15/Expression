public class Main {

    public static void main(String[] args) {
        Controller c = new Controller(args[0]);
        Double result=c.control();
        printResult(result);
    }
    public static void printResult(Double result)
    {
        System.out.println("Result of given expression is ="+result);
    }


}





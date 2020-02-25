public class Main {

    public static void main(String[] args) {
        Controller c = new Controller(args[0]);
        String result = c.controller();
        printResult(result);
    }
    public static void printResult(String result)
    {
        System.out.println("Result of given expression is ="+result);
    }


}





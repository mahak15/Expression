package Evaluation;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import static java.lang.System.exit;
public class ExpressionTree {
    Node node;
    public List<String> postString;
    OperatorCheck op = new OperatorCheck();
    Number numbers=new Number();
    OperatorTypeCheck operatortype = new OperatorTypeCheck();

    public Node constructTree(List<String> postString) {
        Stack<Node> stack = new Stack();

        Node temp, right, left;
        int flag = 0;
        for (int i = 0; i < postString.size(); i++) {
            if (postString.get(i)!="") {
                temp = new Node(postString.get(i));
                stack.push(temp);
            }
            else if(op.isOperator(postString.get(i))) {
                if (operatortype.typeOfOperator(postString.get(i)).equals("binaryOperator")) {
                    temp = new Node(postString.get(i));
                    try {
                        right = stack.pop();
                        left = stack.pop();
                        temp.right = right;
                        temp.left = left;
                    }
                    catch (EmptyStackException e)
                    {
                        System.out.println(postString.get(i)+" "+"is a binary operand!Two operands required");
                        exit(0);
                    }

                    stack.push(temp);
                }
                else if (operatortype.typeOfOperator(postString.get(i)).equals("unaryOperator")) {
                    temp = new Node(postString.get(i));
                    try {
                        right = stack.pop();
                        temp.right = right;
                    }
                    catch (EmptyStackException e)
                    {
                        System.out.println(postString.get(i)+" "+"is a unary operator!One operands required");
                        exit(0);
                    }
                    stack.push(temp);
                }
            }
        }
        if(stack.size()==-1) {
            System.out.println("Invalid Operator Used!");
            exit(0);
        }
        temp=stack.pop();
        System.out.print(temp.value+" "+temp.right.value);
        return temp;
    }
}

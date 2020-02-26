/*package Evaluation;


import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import static java.lang.System.exit;
public class ExpressionTree {
        Node node;
    public List<String> postfix;
       IsOperator validOperator = new IsOperator();
        Numbers numbers=new Numbers();
        OperatorType operatortype = new OperatorType();

        public Node constructTree(List<String> postfix) {
            Stack<Node> stack = new Stack();

            Node temp, right, left;
            int flag = 0;
            for (int i = 0; i < postfix.size(); i++) {
                if (!(postfix.get(i))) {
                    temp = new Node(postfix.get(i));
                    stack.push(temp);
                }
                else if(validOperator.isOperator(postfix.get(i))) {
                    if (operatortype.getOperatorType(postfix.get(i)).equals("binaryOperator")) {
                        temp = new Node(postfix.get(i));
                        try {
                            right = stack.pop();
                            left = stack.pop();
                            temp.right = right;
                            temp.left = left;
                        }
                        catch (EmptyStackException e)
                        {
                            System.out.println(postfix.get(i)+" "+"is a binary operand!Two operands required");
                            exit(0);
                        }

                        stack.push(temp);
                    }
                    else if (operatortype.getOperatorType(postfix.get(i)).equals("unaryOperator")) {
                        temp = new Node(postfix.get(i));
                        try {
                            right = stack.pop();
                            temp.right = right;
                        }
                        catch (EmptyStackException e)
                        {
                            System.out.println(postfix.get(i)+" "+"is a unary operator!One operands required");
                            exit(0);
                        }
                        stack.push(temp);
                    }
                }
            }
            if(stack.size()>1) {
                System.out.println("Invalid Operator Used!");
                exit(0);
            }
            temp=stack.pop();
            return temp;
        }
        }
    }*/
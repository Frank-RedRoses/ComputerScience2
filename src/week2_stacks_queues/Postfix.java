package week2_stacks_queues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Stack client example: Postfix expression evaluation
// Ex. 
// Input: 1 2 3 + 4 5 * * + 
// Output: 101.0
public class Postfix {

    public static void main(String[] args) {

        Stack<Double> stack = new Stack<Double>();
        /* 
         * Algorithm:
         * While input stream is nonempty, read a token.
         * Check the token and take actions according to the type of token:
         *  - Value: push() onto the stack.
         *  - Operator: pop() operand(s), apply operator, push() the result.
         */
        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();
            switch (token) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop()); 
                    break;
                case "/":
                    stack.push((1.0/stack.pop()) * stack.pop()); 
                    break;
                case "sqrt":
                    stack.push(Math.sqrt(stack.pop())); 
                    break;          
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }
        StdOut.println(stack.pop());
    }

}

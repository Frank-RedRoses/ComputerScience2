package week2_stacks_queues.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import week2_stacks_queues.Stack;

// InfixToPostfix converts an arithmetic expression from infix to postfix.
// Ex. 
// Input: ( 1 + ( ( 2 + 3 + 10 ) * ( 4 * 5 ) ) )
// Output: 1 2 3 10 + + 4 5 * * +
public class InfixToPostfix {

    public static void main(String[] args) {
        String postfix = "";                            // the postfix expression
        Stack<String> operand = new Stack<String>();    // Operands in LIFO order

        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();          // read the infix espression, spaces are used to separate tokens.
            if (token.equals("(") || token.equals("+")        // store the operands in the stack.
                    || token.equals("-") || token.equals("*") 
                    || token.equals("/")) 
                operand.push(token);
            else if (token.equals(")")) {                              // add the operands to the postfix expression 
                String mathOperand = operand.pop();
                while (!mathOperand.equals("(")) {                          // stop adding operands when a '(' is found
                    postfix += mathOperand + " ";
                    mathOperand = operand.pop();
                }
            } else                                                              // otherwise add the numbers to the postfix expression
                postfix += token + " ";
        }

        StdOut.println(postfix);                      // print out the postfix expression
    }

}



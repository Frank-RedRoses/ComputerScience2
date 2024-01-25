package week2_stacks_queues.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import week2_stacks_queues.Stack;

public class Parentheses {

    public static boolean isBalanced(String str) {
        // new Stack
        Stack<Character> stack = new Stack<Character>();
        // empty string
        if (str.equals("") || str == null) 
            return false;
        // check for balance in parentheses
        char symbol;
        for (int i = 0; i < str.length(); i++) {
            symbol = str.charAt(i);
            switch (symbol) {
                case ')':
                    if (stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.pop() != '{') return false;
                    break;
                default:
                    stack.push(symbol);
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = StdIn.readString();
        StdOut.println(isBalanced(str));
    }
}

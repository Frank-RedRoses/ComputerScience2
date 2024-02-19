package week5_tms;

import edu.princeton.cs.algs4.Stack;

/**
 * Program 5.2.1 Virtual Turing machine tape.
 * This program uses two pushdown stacks to emulate the infinite tape 
 * needed by Turing machines. The symbol under the tape head is kept 
 * in the variable current, symbols to its left are in the pushdown 
 * stack left, and symbols to its right are in the pushdown stack right.
 */
public class Tape {

    // Simulate the infinite input tape with two stacks, one for each end.
    private Stack<Character> left = new Stack<Character>();  // --> fill in from left to right end 
    private Stack<Character> right = new Stack<Character>(); // <-- fill in from right to left end
    private char current;


    // The "tape head" is pointing to the current char
    // We start with all the input in the right stack.
    public Tape(String input) {
        right.push('#');
        // fill the tape from right to left;
        for(int i = input.length() - 1; i >= 0; i--)
            right.push(input.charAt(i));
        // send the top value of the right stack to the "tape head"
        current = right.pop();

    }
    
    /* 
    // Read and Write operations
    // To simulate TM tape need to call write() exactly once after
    // each call on read()
    */

    // Return the current char on the "tape head"
    public char read() {
        return current;
    }

    // Change the current symbol
    public void write(char symbol) {
        current = symbol;
    }

    // Movements of the infinite tape.
    // We increase left side and decrease left side
    public void moveRight() {
        left.push(current);
        if (right.isEmpty()) left.push('#');
        current = right.pop();
    }

    // We increase right side and decrease left side
    public void moveLeft() {
        right.push(current);
        if (left.isEmpty()) left.push('#');
        current = left.pop();
    }

    // Convert the contents of the tape to String
    public String toString() {
        StringBuilder tapeContents = new StringBuilder();
        // add the left side
        for (Character c : left) {
            if (c != '#') tapeContents.append(c);
        }
        tapeContents.reverse();
        // add the current character
        if (current != '#') tapeContents.append(current);
        // add the right side
        for (Character c : right) {
            if (c != '#') tapeContents.append(c);
        }
        // to String
        return tapeContents.toString();
    }

    public static void main(String[] args) {
        
    }
}

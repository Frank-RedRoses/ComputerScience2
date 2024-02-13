package week4_dfas;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import week3_symbol_tables.BST;

/**
 * Simulating the operation of a DFA.
 * 
 * Input file:
 * % more b3.txt
 * 3
 * ab
 * 0
 * True 0 1
 * False 1 2
 * False 2 0
 * 
 * Test code cases:
 * % java DFA b3.txt
 * bababa
 * Yes
 * bb
 * No
 * abbabbababbbabaaa
 * Yes
 * abbabbababbba
 * No
 */
public class DFA {

    private int startState;                         // initial state of the DFA
    private boolean[] action;                       // action related to every state 
    private BinaryST<Character, Integer>[] nextStates;    // input-next State pair to indicate to what state go next
    /* Also, another option is to use a BST<> array with a casting:
     * private BST<Character, Integer>[] nextStates; 
     */

    /* How BinaryST<Character, Integer>[] nextStates is implemented?
     * BinaryST<Key, Value> is an interface, this allows the use of 
     * GENERIC DATA TYPE with an array, the way is to use BinaryST<Key, Value>  
     * references to point instances of classes that implement the 
     * BinaryST<Key, Value> interface, like the BST<Character, Integer> class.
     * This way you can have an array of objects that are related throught
     * a common interface and call the methods based on the common interface
     * methods (polimorphism).
     */

    // The Constructor is use to fill in the data structures
    // This code depends on the structure of the input file
    public DFA(String filename) {                   
        In in = new In(filename);                   // input from file .txt    
        // Read the # states, alphabet and start state.      
        int nStates = in.readInt();                 // get the number of states of the DFA
        char[] alphabet = in.readString().toCharArray();    // get chars from the string alphabet
        this.startState = in.readInt();             // get the initial state of the DFA
        // create the arrays
        action = new boolean[nStates];              // Yes(true) or NO(false) label for each state. 
        nextStates = new BinaryST[nStates];         // symbol-nextState relation to handle transitions between states.
        // Also, the option with the casting:
        // nextStates = (BST<Character, Integer>[]) new BST[nStates];

        /*
         * The BinaryST[] array stores [nStates] references to objects that 
         * implement the BinaryST interface. 
         * The using references of the interface allow us to use the common 
         * methods between objects.
         */
        for (int state = 0; state < nStates; state++) {         // every line on the rest of the input file represents an state 
            action[state] = in.readBoolean();           // read the action representing Yes or No in the current state.
            nextStates[state] = new BST<Character, Integer>();  // assing a BST in the array of references
            for (int j = 0; j < alphabet.length; j++)       // fill the Binary Symbol Table
                nextStates[state].put(alphabet[j], in.readInt());  // assign the next state depending on the char. 
        }
    }

    /**
     * This method operates the DFA, evalues the input string and return 
     * if the string is in the language defined by the DFA.
     * 
     * @returns True if is in the language defined by the DFA, otherwise False.
     */ 
    public boolean recognizes(String input) {
        int state = startState;
        for (int i = 0; i < input.length(); i++) 
            state = nextStates[state].get(input.charAt(i)); // assign the next state depending on the input char
        return action[state];
    }

    public static void main(String[] args) {
        DFA dfa = new DFA(args[0]);
        String input;
        while (!StdIn.isEmpty()) {
            input = StdIn.readString();
            if (dfa.recognizes(input))  StdOut.println("Yes");
            else                        StdOut.println("No"); 
        }
    }
}
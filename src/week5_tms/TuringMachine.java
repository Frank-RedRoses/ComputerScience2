package week5_tms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Program 5.2.2 Universal virtual TM.
 * This program simulates the operation of the TM specified as 
 * the first command-line argument for each of the strings on 
 * standard input. If the TM halts, the program prints Yes, No, 
 * or Halt, followed by the contents of the tape. Alternatively,
 * it might go into an infinite loop.
 */
public class TuringMachine {

    private int state;                          // current state
    private int start;                          // initial state
    private char[] action;                      // action per state;                 action[state]
    private ST<Character, Integer>[] next;      // transitions by symbol per state;  next[state]
    private ST<Character, Character>[] out;     // outputs by symbol per state;      out[state] 

    // Fill in the data structures from txt file
    public TuringMachine(String filename) {
        // Input file
        In in = new In(filename);
        // Read the initial parameters from input file
        int nStates = in.readInt();         // Number of states
        String alphabet = in.readString();  // Symbols to work with
        start = in.readInt();               // Start state number
        // Action per state = Left, Right, Halt, Yes, No (L, R, H, Y, N). 
        action = new char[nStates];
        // Create the data structure to store the nextState-by-symbol and the output-by-input.
        next = (ST<Character, Integer>[]) new ST[nStates];
        out = (ST<Character, Character>[]) new ST[nStates];
        // Fill in the states data (states by input line).
        for (int st = 0; st < nStates; st++) {
            // First take the state's action
            action[st] = in.readString().charAt(0);
            // fill no data if state's action equals halt, yes or no.
            if (action[st] == 'H') continue;    // halt
            if (action[st] == 'Y') continue;    // yes
            if (action[st] == 'N') continue;    // no
            
            // Next, fill alphabet.length() number of state transitions by symbol
            next[st] = new ST<Character, Integer> ();
            // by alphabet char order:
            for (int i = 0; i < alphabet.length(); i++) {
                int state = in.readInt();   // next state
                next[st].put(alphabet.charAt(i), state); // ithSymbol-nextState pair
            }

            // Finally, fill Input-Output relation (Read-Write)
            out[st] = new ST<Character, Character>();
            // by alphabet char order
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = in.readString().charAt(0);    // output symbol
                out[st].put(alphabet.charAt(i), symbol); // ithSymbol-outputSymbol pair
            }
        }
    }

    public String simulate(String input) {
        // initial current state
        state = start;
        // create the tape and fill in the TM configuration and input data 
        Tape tape = new Tape(input);
        // run the TM until it halts
        while (action[state] != 'H') {
            char c = tape.read();           // read a symbol 
            tape.write(out[state].get(c));  // write the corresponding output
            state = next[state].get(c);     // move to the corresponding next state
            // move the tape according to the action on the new state
            if (action[state] == 'R') tape.moveRight(); 
            if (action[state] == 'L') tape.moveLeft();
        }

        return action[state] + " " + tape;
    }

    // similar to DFA main
     public static void main(String[] args) {
        // args[0]  = name of the configuration file. Ex: dec.txt (see slides)
        TuringMachine tm = new TuringMachine(args[0]);
        String inputTape;
        while (!StdIn.isEmpty()) {
            inputTape = StdIn.readLine();   // 
            StdOut.println(tm.simulate(inputTape));
        }
     }
    


}

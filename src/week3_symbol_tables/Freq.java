package week3_symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Goal. Compute frequencies of words on standard input.
 * • Key type. String (word on standard input).
 * • Value type. Integer (frequency count).
 */
public class Freq {
    public static void main(String[] args) {
        // Frequency counter
        BST<String, Integer> st = new BST<String, Integer>();
        while(!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (st.contains(key)) st.put(key, st.get(key) + 1);
            else                  st.put(key, 1);
        }
        for (String s : st.keys()) {
            StdOut.printf("8%d %s\n", st.get(s), s);
        }
    }

}

package week3_symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Goal. Print index to words on standard input.
 * • Key type. String (word on standard input).
 * • Value type. Queue<Integer> (indices where word occurs).
 */

public class Index {

    public static void main(String[] args) {
        BST<String, Queue<Integer>> st;
        st = new BST<String, Queue<Integer>>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if (!st.contains(key)) 
                st.put(key, new Queue<Integer>());
            st.get(key).enqueue(i);
        }
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s));
    }

}

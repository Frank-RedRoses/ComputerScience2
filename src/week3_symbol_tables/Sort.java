package week3_symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Symbol table client example 1: Sort (with dedup)
 * Goal. Sort lines on standard input (and remove duplicates).
 * • Key type. String (line on standard input).
 * • Value type. (ignored)
 */
public class Sort {

    public static void main(String[] args) {
        // Sort lines on StdIn
        BST<String, Integer> st = new BST<String, Integer>();
        while (!StdIn.isEmpty()) 
            st.put(StdIn.readLine(), 0);
        for (String str : st.keys()) 
            StdOut.println(str);

    }

}

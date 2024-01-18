package week1_search_sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * WhiteList is filter that take a list of Strings to be accepted 
 * for service (the opposite of a blacklist) and print out those that
 * than are present in a list of Strings from the input.
 */
public class WhiteList {

    // Strawman implementation: Sequential Search
    /* Mathematical analysis:
     * N strings on a whitelist.
     * c*N transactions for constant c.
     * String length is not long (length is negligible for the running time).
     * 
     * A random search:
     *  - with matches will check on average half of the N strings.
     *  - with misses will check on average all of the N strings.
     *  - expect order of growth of running time is N^2.
     */
    public static int sequentialSearch(String key, String[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i].compareTo(key) == 0) return i; // return the index number for a match
        return -1;                                  // otherwise not found
    }

    public static void main(String[] args) {
        In in = new In(args[0]);                // args[0] = name of the txt file containing the whitelist
        String[] whiteList = in.readAllStrings();   

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (sequentialSearch(key, whiteList) != -1)   // search() should return the index position or -1 for a miss
                StdOut.println(key);
        }
    } 
}
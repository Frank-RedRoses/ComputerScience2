package week1_search_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// Test client for Sequential Search
public class TestSS {

    /*
     * This method checks if the "key" is inside the array arr[ ]
     * and returns the index of key inside arr[ ]. 
     * Otherwise, returns -1.
     */
    public static int search(String key, String[] arr) {
        return sequentialSearch(key, arr);
    }

    /*
     * Search for String key inside an array arr[] in from index 0 to N.
     * Returns the index of the match in arr[].
     * Otherwise, no match found returns -1.
     */
    public static int sequentialSearch(String key, String[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].compareTo(key) == 0)
                return i;
        return -1;
    }


    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        int N = words.length;
        double start = System.currentTimeMillis() / 1000.0; // current time in seconds
        for (int i = 0; i < N; i++) {
            String key = words[StdRandom.uniform(N)]; // select a random String from whitelist to do the search.
            if (search(key, words) == -1) // Condition never meet, key is a random String from words[].
                StdOut.println(key); // No Output, this line is never reached.
        }
        Double now = System.currentTimeMillis() / 1000.0; // current time in secods
        StdOut.println(Math.round(now - start) + " seconds");
    }
}

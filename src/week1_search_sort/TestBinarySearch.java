package week1_search_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// Test client for Binary Search
public class TestBinarySearch {

     /*
     * This method checks if the "key" is inside the array arr[ ]
     * and returns the index of key inside a[ ]. 
     * Otherwise, returns -1.
     */
    public static int search(String key, String[] arr) {
        return binarySearch(key, arr, 0, arr.length);
    }

    /*
     * Binary search implementation:
     * Keep the array in sorted order (stay tuned).
     * Examine the middle value against key.
     * If middle is larger, do a recursive search to the half with lower indices.
     * If middle is smaller, do a recursive search to the half with upper indices.
     * If it matches, return its index.
     * Recursively keep searching, if there is no match then hi index 
     * will be <= lo index, return -1 to indicate a miss (base case).
     */
    public static int binarySearch(String key, String[] arr, int lo, int hi) {
        if (hi <= lo) return -1;    // base case. (Ends recursive calls)
        int mid = lo + (hi - lo) / 2;
        // recursive step:
        int comparative = arr[mid].compareTo(key); // returns -1, 0, +1. (less, equal, greater)
        if (comparative > 0) return binarySearch(key, arr, lo, mid);
        else if (comparative < 0) return binarySearch(key, arr, mid + 1, hi);
        else return mid;
    }

    public static void main(String[] args) {
        String[] whiteList = StdIn.readAllStrings();
        Merge.sort(whiteList);    
        int N = whiteList.length;
        double start = System.currentTimeMillis() / 1000.0; // current time in seconds
        for (int i = 0; i < N; i++) {
            String key = whiteList[StdRandom.uniform(N)]; // select a random key from Whitelist.
            if (search(key, whiteList) == -1) // Always false, key is a random String from whiteList[].
                StdOut.println(key); // No Output, this line is never reached.
        }
        Double now = System.currentTimeMillis() / 1000.0; // current time in secods
        StdOut.println(Math.round(now - start) + " seconds");
    }

}

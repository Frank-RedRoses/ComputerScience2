package week1_search_sort.optional_enrichment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {

    /*
     * Binary search using a nonrecursive implementation, it return the 
     * index of arr[index] equal to key.
     */
    public static int searchNonRecursive(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length;
        while (hi > lo) {
            int mid = lo + (hi - lo)/2;
            // look for a arr[mid] value that is equal to the key.
            if (arr[mid] > key)         hi = mid;       // search from "lo" to "mid"
            else if (arr[mid] < key)    lo = mid + 1;   // search from "mid + 1" to "hi"
            else return mid;                            // arr[mid] equals keys
        }  
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        // int counter = 0; // debug code
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();  // a value from a list of ints from StdInput
            /* for debug
            if (key < 16)   // 15 is the largest value in the whitelist
            counter++;      // counts how many times a value is less than 16 in the input
            */
            // search, prints the key values that match the whitelist.
            if (searchNonRecursive(key, whitelist) != -1) 
            StdOut.println(key);
        }
        // for debug
        // StdOut.println("counter = " + counter);
    }

}

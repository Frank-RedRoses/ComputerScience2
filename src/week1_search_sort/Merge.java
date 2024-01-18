package week1_search_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {
    
    private static String[] aux;

    /*
     * Merge in place, copy the results to an auxiliary array and 
     * copying back when the merge is complete.
     */
    public static void merge(String[] arr, int lo, int mid, int hi) {
        // Merge arr[lo, mid) with arr[mid, hi) into aux[0, hi - lo)
        int i = lo, j = mid, N = hi - lo;
        // k follow the indexes of aux[]
        for (int k = 0; k < N; k++) {
            // Edge cases for when any of the two halves have been exhausted.
            if (i == mid) aux[k] = arr[j++];        // lower half exhausted
            else if (j == hi) aux[k] = arr[i++];    // upper half exhausted
            // Compare and copy the smaller value to aux[k], increment i or j depending on the smaller value.
            else if (arr[j].compareTo(arr[i]) < 0) aux[k] = arr[j++];
            else aux[k] = arr[i++];
        }
        // Copy back into arr[lo, hi)
        for (int k = 0; k < N; k++) {
            arr[lo + k] = aux[k];
        }
    }

    // Sort entry method
    public static void sort(String[] arr) {
        aux = new String[arr.length];
        sort(arr, 0, arr.length);
    }

    /*
     * Mergesort:
     * - Divide array into two halves.
     * - Recursively sort each half.
     * - Merge two halves to make sorted whole.
     */
    public static void sort(String[] arr, int lo, int hi) {
        int N = hi - lo;
        if (N <= 1) return; // Base case: stop when arr size is 1 or less
        int mid = lo + N/2;
        // Recursively divide the arr[] in two halves until N <= 1 is reach.
        sort(arr, lo, mid); 
        sort(arr, mid, hi);
        // Sort arr[] bottom-up
        merge(arr, lo, mid, hi); // this method does the actual sorting by comparing the two halves.
    }

    public static void main(String[] args) {
        String[] arr = StdIn.readAllStrings();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i]);
        }
    }

    /*
     * Mergesort:
     * Now sorting is so important that people have studied other methods
     * and there are methods that are constant factors faster than this, 
     * but certainly by comparison with insertion sort, this method solves
     * our problem. 
     * 
     * Mergesort scales and that's what we need, it is a scalable method so that 
     * as our data grows, we can grow with it along with Moore's Law.
     */

}

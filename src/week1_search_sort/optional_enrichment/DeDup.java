package week1_search_sort.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Write a filter that reads strings from standard input 
 * and prints them to standard output, in sorted order 
 * with all duplicate strings removed.
 */
public class DeDup {

    private static String[] aux;

    public static void merge(String[] arr, int lo, int mid, int hi) {
        int N = hi - lo;
        int i = lo, j = mid;
        for (int k = 0; k < N; k++) {
            if (i == mid) aux[k] = arr[j++];        // lower half exhausted
            else if (j == hi) aux[k] = arr[i++];   // upper half exhausted
            // pass the smaller value to aux[]
            else if (arr[j].compareTo(arr[i]) < 0) aux[k] = arr[j++];
            else aux[k] = arr[i++]; 
        }
        // copy back the sorted values to arr[]
        for (int k = 0; k < N; k++) {
            arr[lo + k] = aux[k]; 
        }
    }

    public static void sort(String[] unsortedStr) {
        aux = new String[unsortedStr.length];
        sort(unsortedStr, 0, unsortedStr.length);
    }

    private static void sort(String[] arr, int lo, int hi) {
        int N = hi - lo;
        if (N <= 1) return;
        int mid = lo + N / 2;
        sort(arr, lo, mid);
        sort(arr, mid, hi);
        merge(arr, lo, mid, hi);
    }

    public static void outputFilter(String[] words) {
        String prev = "";
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals(prev)){
                StdOut.println(words[i]);
                prev = words[i]; 
            }
        }
    }

    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        // sort the words
        sort(words);
        // print out only non-repeated strings
        outputFilter(words);
    }

}

package week1_search_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {

    /*
     * Rearrange N items to put them in ascending order using the following 
     * algorithm:
     * - Move down throug the array.
     * - Each item bubbles up above larger items above it.
     * - Everything above the current item (i) is in order.
     * - Everything below the current item (i) is untouched.
     */
    public static void sort(String[] arr) {
        int N = arr.length;
        // take the index element to be sort.
        for (int i = 1; i < N; i++) {
            // sorting it until arr[j - 1].compareTo(arr[j]) equals 0 or -1
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0)
                    exch(arr, j - 1, j);
                else break;
            }
        }
    }

    // exchange position between two elements in arr[]
    public static void exch(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String[] arr = StdIn.readAllStrings();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i]);
        }
    }

    /*
     * Insertion sort:
     * Order of growth is N2.
     * 
     * Insertion sort does not scale with the size of the problem, 
     * the order of grow is N^2, which means it takes 4x times to 
     * solve a problem with double size of data from the original 
     * size problem.
     */



}

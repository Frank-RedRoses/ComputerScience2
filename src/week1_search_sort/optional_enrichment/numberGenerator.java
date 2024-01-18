package week1_search_sort.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// Generates a list of random numbers between [0, topvalue)
public class numberGenerator {
    public static void main(String[] args) {
        int topValue = Integer.parseInt(args[0]);
        int[] numbers = new int[topValue];
        // fill an array with the random numbers
        for (int i = 0; i < topValue; i++) {
            numbers[i] = StdRandom.uniform(topValue);
        }
        // print the array
        for (int i = 0; i < numbers.length; i++) {
            StdOut.println(numbers[i]);
        }
        
    }
}

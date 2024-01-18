package week1_search_sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Generator {

    // Simple method to return a generated string composed by random letters
    // Length (length of the generated string)
    // alpha (alphabet)
    public static String randomString(int Length, String alpha) {
        char[] randLetters = new char[Length];
        // fill every letter of the generated string with a random character from the alphabet
        for (int i = 0; i < Length; i++) {
            int index = StdRandom.uniform(alpha.length());
            randLetters[i] = alpha.charAt(index);
        }
        return new String(randLetters);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);  // total number of generated strings
        int L = Integer.parseInt(args[1]);  // length of the generated string
        String alpha = args[2];             // alphabet use to get letters
        for (int i = 0; i < N; i++) 
            StdOut.println(randomString(L, alpha));
    }


}

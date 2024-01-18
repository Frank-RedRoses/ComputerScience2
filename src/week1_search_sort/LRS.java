package week1_search_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LRS {

    /* Longest common prefix (lcp):
     * Find the longest substring that appears at the beginning
     * of two strings s and t with different length.
     *  - Take the shortest length between s and t.
     *  - Compare char by char both strings until the shortest length.
     *  - At the first finding of a difference between chars 
     *    return the substring[0, i)
     *  - Otherwise the shortest string is the longest common prefix, 
     *    return the substring[0, N), 
     *  - It doesn't matter which string is used to return the substring.
    */
    public static String lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());   // N to stop the for-loop
        for (int i = 0; i < N; i++) 
            if (s.charAt(i) != t.charAt(i)) 
                return s.substring(0, i);
        return s.substring(0, N);
    }

    /*
     * Longest repeated substring (lrs):
     * Find the longest substring in a String "s" that appears at least twice
     * using the brute force for-loop.
     * Analysis:
     * (~N^2) / 2 calls on lcp(). Obviously does not scale.
     */
    public static String lrsBruteForce(String s) {
        int N = s.length();
        String lrs = "";
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // use an auxiliary string and look for the longest common prefix
                String aux = lcp(s.substring(i, N), s.substring(j, N));
                // if lcp is larger than lrs update the string.
                if (aux.length() > lrs.length()) lrs = aux;
            }
        }
        return lrs;
    }

    /*
     * Longest repeated substring (lrs) more efficient solution:
     *  1) Form suffix strings.
     *  2) Sort suffix strings.
     *  3) Find lcp() between adjacent suffix strings. 
     * Analysis:
     * - N calls on substring().
     * - N calls on lcp().
     * - Order of growth is N log N (for the sort). Scales with 
     *   the size of the input.
     */
    public static String lrs(String s) {
        // Form the suffix strings
        int N = s.length();
        String[] suffixes = new String[N];
        for(int i = 0; i < N; i++) 
            suffixes[i] = s.substring(i, N);
        
        // Sort suffix strings
        Merge.sort(suffixes);

        // Find the longest lcp among adjacent entries
        String lrs ="";
        for (int i = 0; i < N-1; i++) {
            String aux = lcp(suffixes[i], suffixes[i + 1]);
            if (aux.length() > lrs.length()) lrs = aux;
        }
        return lrs;
    }

    public static void main(String[] args) {
        String s = StdIn.readAll();
        StdOut.println(lrs(s));
    }

    /*
     * Final note on LRS implementation.
     * For long repeats strings: 
     * • More precise analysis reveals that running time
     *   is quadratic in the length of the longest repeat.
     * • Model has no long repeats.
     * • Real data may have long repeats.
     * • Linear time algorithm (guarantee) is known.
     */

}

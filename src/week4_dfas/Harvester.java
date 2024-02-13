package week4_dfas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


/**
 * Harvest information from input stream
 * • Take RE from command line
 * • Take input from file or web page.
 * • Print all substrings matching RE.
 * 
 * 
 * % java Harvester "gcg(cgg|agg)*ctg" chromosomeX.txt
 * gcgcggcggcggcggcggctg
 * gcgctg
 * gcgctg
 * gcgcggcggcggaggcggaggcggctg
 */
public class Harvester {

    public static void main(String[] args) {
        String re = args[0];
        In in = new In(args[1]);
        String input = in.readAll();
        Pattern pattern = Pattern.compile(re); // creates an automata from the Regular expression
        Matcher matcher = pattern.matcher(input); // Creates a matcher to check the input
        while (matcher.find()) {        // the matches looks inside the input if find any then print the previous
            StdOut.println(matcher.group());    // prints out the last match found
        }
    }
}

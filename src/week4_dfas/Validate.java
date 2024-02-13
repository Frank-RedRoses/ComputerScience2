package week4_dfas;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Does a given string match a given RE?
 * • Take RE from command line.
 * • Take strings from StdIn.
 * 
 * % java Validate "C.{2,4}C...[LIVMFYWC].{8}H.{3,5}H"
 * CAASCGGPYACGGAAGYHAGAH
 * true
 * CAASCGGPYACGGAAGYHGAH
 * false
 * 
 * % java Validate "[$_A-Za-z][$_A-Za-z0-9]*"
 * ident123
 * true
 * 123ident
 * false
 * 
 * % java Validate "[a-z]+@([a-z]+\.)+(edu|com)"
 * wayne@cs.princeton.edu
 * true
 * eve@airport
 * false
 */
public class Validate {

    public static void main(String[] args) {
        String re = args[0];
        while(!StdIn.isEmpty()) {
            String input = StdIn.readString();
            StdOut.println(input.matches(re));
        }
    }
}

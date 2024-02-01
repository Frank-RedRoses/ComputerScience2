package week3_symbol_tables.optional_enrichment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import week3_symbol_tables.BST;

/******************************************************************************
 *  Compilation:  javac Lookup.java
 *  Execution:    java Lookup file.csv keyField valField
 *  Dependencies: ST.java In.java StdIn.java
 *  Data files:   https://introcs.cs.princeton.edu/java/44st/amino.csv
 *                https://introcs.cs.princeton.edu/java/44st/ip.csv
 *                https://introcs.cs.princeton.edu/java/44st/DJIA.csv
 *                https://introcs.cs.princeton.edu/java/44st/morse.csv
 *                https://introcs.cs.princeton.edu/java/44st/elements.csv
 *                https://introcs.cs.princeton.edu/java/44st/mktsymbols.csv
 *                https://introcs.cs.princeton.edu/java/44st/toplevel-domain.csv
 *
 *  Reads in a set of key-value pairs from a two-column CSV file
 *  specified on the command line; then, reads in keys from standard
 *  input and prints out corresponding values.
 *
 *  % java Lookup amino.csv 0 3      % java Lookup ip.csv 0 1
 *  TTA                              google.com
 *  Leucine                          64.233.167.99
 *  ABC
 *  Not found                        % java Lookup ip.csv 1 0
 *  TCT                              64.233.167.99
 *  Serine                           google.com
 *
 *  % java Lookup amino.csv 3 0      java Lookup DJIA.csv 0 1
 *  Glycine                          29-Oct-29
 *  GGG                              252.38
 *                                   20-Oct-87
 *                                   1738.74
 *
 ******************************************************************************/
public class Lookup {

    public static void main(String[] args) {
        String fileName = args[0];                          // name of the cvs file
        In inputFile = new In(fileName);                    // input stream from cvs file
        int keyField = Integer.parseInt(args[1]);           // column on the cvs file for keys
        int valField = Integer.parseInt(args[2]);           // column on the cvs file for values
        String[] database = inputFile.readAllLines();       // store the lines of the cvs in an array 
        BST<String, String> st = new BST<String, String>(); // create the BST for storing String pairs
        for (int i = 0; i < database.length; i++) {         // iterate every entry of the database
            String[] tokens = database[i].split(","); // save the entries on one line into an another array
            String key = tokens[keyField];                  // get the key with the key column on the cvs file
            String val = tokens[valField];                  // get the value with the value column on the cvs file
            st.put(key, val);                               // save the key-value pair into the BST
        }
        
        double start = System.currentTimeMillis() ;
        while (!StdIn.isEmpty()) {                           
            String str = StdIn.readString();                // Read from standard input a string
            // if (st.contains(str)) StdOut.println(st.get(str));  // search the string in the BST and print out
            if (st.contains(str)) st.get(str);  // it only search for the string in the BST
            else StdOut.println("Not found");
        }
        double now = System.currentTimeMillis();
        StdOut.println(Math.round(now - start) + " miliseconds");
    }

}

package week3_symbol_tables.optional_enrichment;

import java.io.PrintWriter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class KeyGenerator {

    private static final String workspace = "C:\\Users\\frank\\Coding\\Courses\\Computer.Science.part2.Algorithms.Theory.and.Machines\\Workspace\\ComputerScience2\\";
    private static final int nKeyLimit = 2560000;

    public static void main(String[] args) {
        String abcdary = args[0];
        int keyLength = Integer.parseInt(args[1]);
        int initialNKeys = Integer.parseInt(args[2]);
        
        String path = "resources\\in\\searchtrees\\";
        String filename;
        StringBuilder key;
        try {
            for (int nKeys = initialNKeys; nKeys < nKeyLimit; nKeys *= 2) {
                filename = "rdm_genes" + nKeys + ".txt";
                PrintWriter printer = new PrintWriter(workspace + path + filename);
                for (int i = 0; i < nKeys; i++) {
                    key = new StringBuilder();
                    for (int j = 0; j < keyLength; j++) {
                        key.append(abcdary.charAt(StdRandom.uniform(abcdary.length())));
                    }
                    printer.println(key.toString());
                    /* If BASH: "cannot overwrite existing file" error
                     * Use this command line in the bash terminal:
                     * set +o noclobber 
                    */
                }
                printer.close();
            } 
        } catch (Exception e) {
            StdOut.println("An error had occurred while writing the file.");
            e.printStackTrace();
        }
        
    }

}

package week2_stacks_queues;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Queue client example (QEx)
public class QEx {

    public static String[] readAllStrings() {
        Queue<String> q = new Queue<String>();  // <String> declares a Queue of Strings 

        while (!StdIn.isEmpty())                // enqueue all the words in the standard input
            q.enqueue(StdIn.readString());
        int N = q.size();                       // take the size of the queue
        String[] words = new String[N];         // create the array size N  
        for (int i = 0; i < N; i++)             // fill the array with the values of the queue
            words[i] = q.dequeue();
        return words;
    }

    public static void main(String[] args) {
        String[] words = readAllStrings();
        for (int i = 0; i < words.length; i++) {
            StdOut.println(words[i]);
        }
    }

}

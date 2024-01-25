package week2_stacks_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StrawmanStack {
    // Data structure choice: An array to hold the collection.
    private final String[] arr;
    private int N = 0;

    public StrawmanStack(int max) {
        // create a stack of max capacity
        arr = new String[max];
    }

    public void push(String item) {
        // add an item to the stack.
        arr[N++] = item;
    }

    public String pop() {
        // return the string most recently pushed.
        return arr[--N];
    }

    public boolean isEmpty() {
        // is the stack empty?
        return (N == 0);
    }

    public int size() {
        // return the number of strings on the stack
        return N;
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        StrawmanStack stack = new StrawmanStack(max);
        // read the values from stdInput
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) 
                StdOut.print(stack.pop() + " ");
            else 
                stack.push(item);
        }
        StdOut.println();
    }

}

package week2_stacks_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Stack API:
 * 
 * public class Stack<Item>
 *           Stack<Item>()          // create a stack of items, all of type Item
 *      void push(Item item)        // add item to stack
 *      Item pop()                  // remove and return the item most recently pushed
 *   boolean isEmpty()              // is the stack empty ?
 *       int size()                 // # of objects on the stack
 */

public class Stack<Item> {

    private Node first = null;      // begining of the stack
    private int N = 0;              // number of items on stack

    private class Node {                            // Nested class
        private Item item;          // the item in the node
        private Node next;          // reference to the next node
    } 

    // Methods:
    // Check if the stack is empty              
    public boolean isEmpty() {                     
        return first == null;   // N == 0 also works
    }

    // push an item into the stack
    public void push(Item item) {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
        N++;
    }

    // pop an item from the stack
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // return how many items are in the stack
    public int size() {
        return N;
    }

    public static void main(String[] args) {        // Test client
        // create the stack of Strings
        Stack<String> stack = new Stack<String>();

        // Use the stack
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

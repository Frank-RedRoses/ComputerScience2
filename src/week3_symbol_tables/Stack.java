package week3_symbol_tables;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item>{
    private int n;          // size of the collection
    private Node first;     // top of the stack

    // helper linked list class 
    private class Node {
        private Item item;
        private Node next;
    }

    // initializes an empty stack
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns the number of items on this stack
     * 
     * @return the number of items on this stack
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this stack is empty
     * 
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Adds item to this stack
     * 
     * @param item the item to add
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and return the most recently added node to this stack
     * 
     * @return the item most recently added
     * @throws NoSuchElementException  if the stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;     // save the item to return
        first = first.next;         // delete first node
        n--;
        return item;                // return the saved item
    }

    /**
     * Returs the most recently added itemm without deleting it
     * 
     * @return the most recently added item to this stack
     * @throws NoSuchElementException if the stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns the string representation of this stack
     * 
     * @return a sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Item item : this) {
            str.append(item);
            str.append(' ');
        }
        return str.toString();
    }

    /**
     * Returns an iterator to this stack that iterates throught the items in LIFO order.
     * 
     * @return an itetator to this stack that iterates throught the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;   // 1) save the current item
            current = current.next;     // 2) change reference to next node
            return item;                // 3) return the saved item
        }
    }


    /**
     * Unit test the {@code Stack} data type
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }

}

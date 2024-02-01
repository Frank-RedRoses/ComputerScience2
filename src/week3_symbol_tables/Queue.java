package week3_symbol_tables;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable <Item>{

    private int n;          // nimber of elements on the queue
    private Node first;     // beginning of queue
    private Node last;      // end of queue

    // helper linked link class
    private class Node {
        private Item item;  // the item in the node
        private Node next;  // reference to next item
    }

    /**
     * Initializes  an empty queue
     */
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty
     * 
     * @return {@code true} if this queue is empty; {@code false} otherwise 
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in this queue
     * 
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue
     * 
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * Add an item to the queue
     * 
     * @param item the item to enqueue
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    /**
     * Removes and return the least recently item added on this queue.
     * 
     * @return the item that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null; // avoid loitering
        return item;
    }
    
    /**
     * Returns the string representation of this queue
     * 
     * @return the sequece of items in FIFO order, separeted by spaces
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Item item : this)
            str.append(item + " ");
        return str.toString();
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order
     * 
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;   // node containing the current item
        
        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on the queue)");
    }






}

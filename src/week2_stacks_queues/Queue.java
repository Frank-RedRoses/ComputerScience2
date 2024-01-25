package week2_stacks_queues;

/*
 * Queue API:
 * 
 * public class Queue<Item>
 *         Queue<Item>()        // create a queue of items, all of type Item
 *    void enqueue(Item item)   // add item to queue
 *    Item dequeue()            // remove and return the item least recently enqueued
 * boolean isEmpty()            // is the queue empty ?
 *     int size()               // # of objects on the queue
 */

public class Queue<Item> {

    // Instance variables
    private int n;          // number of elements on queue
    private Node first;     // begining of queue
    private Node last;      // end of queue

    // Inner class
    private class Node {
        private Item item;  // the item in the node
        private Node next;  // reference to the next item
    }

    // Methods
    // Returns true if this queue is empty.
    public boolean isEmpty() {
        return first == null;
    }

    // Returns the number of items in this queue.
    public int size() {
        return n;
    }

    // Add an item to the queue
    public void enqueue(Item item) {
        Node prevLast = last;           // save reference to last node
        last = new Node();              // make last to point to a new node
        last.item = item;               // assign the item to the new node
        last.next = null;               // assure that new.next equals to null
        if (isEmpty()) first = last;    // first must point to the new point if empty
        else prevLast.next = last;      // otherwise add last to the end of the queue
        n++;
    }

    // returns the least recently added item to this queue
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null; // to avoid loitering
        return item;
    }

}

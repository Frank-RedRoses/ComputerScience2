package week2_stacks_queues.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkListWithRemoval<Item> {

    private Node first = null;
    private int N = 0;

    private class Node {
        private Item item;
        private Node next;
    }

    // add a node to the linklist
    public void addNode(Item item) {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
        N++;
    }

    // get the most recently added item to the linklist
    public Item getRecentItem() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // return the size of the list
    public int size() {
        return N;
    }

    // return true is the list is empty
    public boolean isEmpty() {
        return N == 0;
    }

    // print out every item in the list
    public void transverse() {
        Node x = first;
        while(x != null) {
            StdOut.println(x.item);
            x = x.next;
        }
    }

    // Delete the node after the given node X
    public void removeAfter(Node x) {
        if (x == null || x.next == null) return;
        x.next = x.next.next;
        N--;
    }

    // Delete the node after the given item
    public void removeAfter(Item item) {
        Node x = first;
        while (x != null && !x.item.equals(item)) {
            x = x.next;
        }
        removeAfter(x);
    }


    public static void main(String[] args) {
        // create the list
        LinkListWithRemoval<String> names = new LinkListWithRemoval<String>();
        // Fill the list
        while (!StdIn.isEmpty()) {
            names.addNode(StdIn.readString());
        }
        // Show list content
        StdOut.println("Size of the list: " + names.size());
        names.transverse();
        StdOut.println("");

        // Delete a name next to the given item
        String name = "carlos";
        StdOut.println("The name after " + name + " will be deleted.");
        names.removeAfter(name);
        
        StdOut.println("size of the list: " + names.size() );
        names.transverse();
    }

}

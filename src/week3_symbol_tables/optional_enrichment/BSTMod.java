package week3_symbol_tables.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import week3_symbol_tables.Queue;

/*
 * 4.4.27 Modify BST to add methods min() and max() that return the smallest 
 * (or largest) key in the table (or null if no such key exists).
 */
public class BSTMod<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value val) {
            this.key = key;
            this.value = val;
        }
    }

    //// public methods ////
    // Is the BST empty?
    public boolean isEmpty() {
        return root == null;
    }

    // associate a key with a value
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    // return the value associated to the key, null if none
    public Value get(Key key) {
        return get(root, key);
    }

    // Is there a value associated with the key?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // get all the keys in the table
    public Iterable<Key> keys() {
        Queue<Key> keyCollection = new Queue<Key>();
        inorder(root, keyCollection);
        return keyCollection;

    } 

    // returns the smallest key in the BST or null if empty
    public Key min() {
        if (isEmpty()) return null;
        return getSmallestKey();
    }

    // Returns the largest key in the BST or null if empty
    public Key max() {
        if (isEmpty()) return null;
        return getLargestKey();
    
    }

    //// private methods ////
    /*
     * Find the value associated with a given key in a BST.
     * • If less than the key at the current node, go left.
     * • If greater than the key at the current node, go right
     * 
     * @param x current node
     * @param key key to search for
     * @return the value associated to the given key, null if empty
     */
    private Value get(Node current, Key key) {
        if (current == null)  return null;
        int cmp = key.compareTo(current.key);
        if (cmp < 0) return get(current.left, key);
        else if (cmp > 0) return get(current.right, key);
        else return current.value; 
    }

    /*
     * Goal. Associate a new value with a given key in a BST.
     * • If less than the key at the current node, go left.
     * • If greater than the key at the current node, go right.
     * 
     * Goal. Add a new key-value pair to a BST.
     * • Search for key.
     * • Return link to new node when null reached.
     * 
     * @param x current node
     * @param key key to search for
     * @return current node after been updated.
     */
    private Node put(Node currentN, Key key, Value val) {
        if (currentN == null) return new Node(key, val);
        int cmp = key.compareTo(currentN.key);
        if (cmp < 0) currentN.left = put(currentN.left, key, val);
        else if (cmp > 0) currentN.right = put(currentN.right, key, val);
        else currentN.value = val;
        return currentN;
    }

     /*
     * Goal. Put keys in a BST on a queue, in sorted order.
     * • Do it for the left subtree.
     * • Put the key at the root on the queue.
     * • Do it for the right subtree
     * 
     * @param x current node
     * @param queue queue to store the values in FIFO order
     */
    private void inorder(Node current, Queue<Key> queue) {
        if (current == null) return;
        inorder(current.left, queue);
        queue.enqueue(current.key);
        inorder(current.right, queue);
    }

    /**
     * Returns the smallest value in the Binary Search Tree.
     * Looks for the node on the most left position in the BST 
     * and returns its value.
     * 
     * @return the smallest value in the Binary Search Tree.
     */
    private Key getSmallestKey() {
        Node currentN = root;
        while (currentN.left != null) {
            currentN = currentN.left;
        }
        return currentN.key;
    }

    /**
     * Returns the largest value in the Binary Search Tree.
     * Looks for the node on the most right position in the BST 
     * and returns its value.
     * 
     * @return the largest value in the Binary Search Tree.
     */
    private Key getLargestKey() {
        Node currentN = root;
        while (currentN.right != null) {
            currentN = currentN.right;
        }
        return currentN.key;
    }

    //// test client ////
    // Words frequency counter on Standard input
    public static void main(String[] args) {
        BSTMod<String, Integer> st = new BSTMod<String, Integer>();
        // read a string from standard input and update or add the key in the BST 
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (st.contains(key)) st.put(key, st.get(key) + 1);
            else st.put(key, 1);
        }

        // print out the BST
        for (String key : st.keys()) {
            StdOut.printf("%8d %s\n", st.get(key), key);
        }
        StdOut.println();
        StdOut.println("The min key in the BST is " + st.min());
        StdOut.println("The max key in the BST is " + st.max());
    }

}

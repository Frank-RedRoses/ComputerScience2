package week3_symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import week4_dfas.BinaryST;

public class BST<Key extends Comparable<Key>, Value> implements BinaryST<Key, Value>{

    private Node root = null;
    
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    ///////// Public methods ////////
    // check if the Bianry search tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // associate a key with val
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    // return value associated with key, null if none
    public Value get(Key key) {
        return get(root, key);
    }

    // is there a value associated with the key
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // all the keys in the table
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        inorder(root, queue);
        return queue;
    }

    //////// Private methods /////////
    /*
     * Find the value associated with a given key in a BST.
     * • If less than the key at the current node, go left.
     * • If greater than the key at the current node, go right
     * 
     * @param x current node
     * @param key key to search for
     * @return the value associtated to the given key
     */
    private Value get(Node x, Key key) {
        if (x == null) return null;                     // End of the branch reached.
        int comp = key.compareTo(x.key);
        if      (comp < 0) return get(x.left, key);     // keep searching for against smaller keys
        else if (comp > 0) return get(x.right, key);    // keep searching for against larger keys
        else return x.value;                            // match found
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
    private Node put(Node x, Key key, Value val) {
        if (x == null)  return new Node(key, val);      // end of branch, not match found, add a new node
        int comp = key.compareTo(x.key);
        if      (comp < 0) x.left = put(x.left, key, val);      // update the left branch
        else if (comp > 0) x.right = put(x.right, key, val);    // update the right branch
        else    x.value = val;                                  // match found, update the value of the current node
        return x;                                               // return the current node (after update).
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
    private void inorder(Node x, Queue<Key> queue) {
        if (x == null) return;  // End of the branch
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

    // Words frequency counter on Standard input
    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (st.contains(key)) st.put(key, st.get(key) + 1);
            else st.put(key, 1);
        }
        // get an iterable collection containing only the values of the keys, 
        // iterates the values (strings)
        for (String str : st.keys()) {  
            StdOut.printf("%8d %s\n", st.get(str), str);;
        }
        
    }

}

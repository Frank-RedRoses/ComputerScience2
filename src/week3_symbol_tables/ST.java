package week3_symbol_tables;

import java.util.TreeMap;

/**
 * Implementation of Search Tree (ST) using red-black trees
 * Insert keys in random order.
 * • Same # of black links on every path from root to leaf.
 * • No two red links in a row.
 * • Tree is nearly balanced.
 * • Guaranteed to stay that way!
 */
public class ST<Key extends Comparable<Key>, Value> {

    private TreeMap<Key, Value> st = new TreeMap<Key, Value>();

    
    
    public void put(Key key, Value value) {
        if (value == null)  st.remove(key);
        else                st.put(key, value);
        st.firstKey();
    }

    public Value get(Key key) {
        return st.get(key);
    }

    public Value remove(Key key) {
        return st.remove(key);
    }

    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

}

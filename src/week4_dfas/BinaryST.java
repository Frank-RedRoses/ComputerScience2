package week4_dfas;

public interface BinaryST<Key, Value> {

    public boolean isEmpty();

    public void put(Key key, Value val);

    public Value get(Key key);

    public boolean contains(Key key);

    public Iterable<Key> keys();

}

package pm2.zweiteblatt;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author yunussozeri
 */
public class PM2Map<K, V> implements Map<K, V> {

    private MapPaar<K, V>[] pairs;
    private int size;
    private int cardinality;

    /**
     * Constructor for PM2Map Object with a standard size of 10.
     */
    public PM2Map() {
        this.pairs = new MapPaar[10];
        size = pairs.length;
        cardinality = 0;
    }

    /**
     * PM2Map Constructor with generic MapPaar array parameter.
     *
     * @param pairs
     */
    public PM2Map(MapPaar<K, V>[] pairs) {
        this.pairs = pairs;
        size = pairs.length;
        cardinality = 0;
    }

    /**
     * Returns the cardinality of the Map. This gives information on how many
     * elements are contained in the PM2Map.
     *
     * @return cardinality, the number of elements
     */
    @Override
    public int size() {
        return cardinality;
    }

    /**
     * Tells if the PM2Map is empty.
     *
     * @return true, if there is no elements contained. false, if there are some
     * elements contained.
     */
    @Override
    public boolean isEmpty() {
        return cardinality == 0;
    }

    /**
     * Checks if the given key exists in the PM2Map.
     *
     * @param key the key that is searched for.
     * @return true, if the key already exists. false, if the key does not
     * exists.
     */
    @Override
    public boolean containsKey(Object key) {
        for (var pair : pairs) {
            if (pair != null) {
                if (pair.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the given value exists in the PM2Map.
     *
     * @param value the key that is searched for.
     * @return true, if the value already exists. false, if the value does not
     * exist.
     */
    @Override
    public boolean containsValue(Object value) {
        for (var pair : pairs) {
            if (pair != null) {
                if (pair.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the value for a given key in PM2Map.
     *
     * @param key the key that is searched for.
     * @return val the value stored by the key. null, if the key does not exist.
     */
    @Override
    public V get(Object key) {
        V val = null;
        for (var pair : pairs) {
            if (pair != null) {
                if (pair.getKey().equals(key)) {
                    val = (V) pair.getValue();
                }
            }
        }
        return val;
    }

    /**
     * Puts a key-value pair into the Map. If the key already exists, then the
     * value is replaced and the old value is returned. If the key does not
     * exist, a new key-value pair is appended to the list, and null is
     * returned.
     *
     * @param key the key that shall be added
     * @param value the value that shall be added.
     * @return oldValue, if the key already exists. null, if a new element is
     * appended.
     */
    @Override
    public V put(K key, V value) {
        // if the key already exists, 
        if (containsKey(key)) {
            //replace the value and 
            for (var pair : pairs) {
                if (pair != null) {
                    if (pair.getKey().equals(key)) {
                        var oldValue = pair.getValue();
                        pair.setValue(value);
                        // return the old value
                        return oldValue;
                    }
                }
            }
        }
        // check size
        if (isFull()) {
            // increase size if needed
            increaseSize();
        }

        MapPaar<K, V> pair = new MapPaar<>(key, value);
        // add element to map
        pairs[cardinality] = pair;
        // increase cardinality
        cardinality++;
        // add new element to the next index
        return null;
    }

    private boolean isFull() {
        return cardinality == size;
    }

    /**
     * Doubles the size of the generic MapPaar array.
     */
    private void increaseSize() {
        MapPaar<K, V>[] largerArray = new MapPaar[size * 2];
        System.arraycopy(pairs, 0, largerArray, 0, size);
        pairs = largerArray;
        size = pairs.length;
    }

    /**
     * Removes the key-value pair with the given key from the PM2Map.
     *
     * @param key is the key that is searched.
     * @return value is the value of the pair that is removed. null, if the key
     * does not exist
     */
    @Override
    public V remove(Object key) {
        int index = 0;
        
        if (containsKey(key)) { // if the key exists start searching
            for (var pair : pairs) {
                if (pair != null) {
                    // when the key is founded
                    if (pair.getKey().equals(key)) {
                        //store old value
                        V oldValue = pair.getValue();
                        //replace current pair with an empty pair
                        pairs[index] = new MapPaar();
                        // decrease cardinality by one
                        cardinality--;
                        // return the old value
                        return oldValue;
                    } else{ // increment index until key is found
                        index++;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Clears the Map by removing elements in the MapPaar array.
     */
    @Override
    public void clear() {
        for (int i = 0; i < cardinality; i++) {
            pairs[i] = null;
        }
        cardinality = 0;
    }

    /**
     * Creates a set of all the keys in the PM2Map.
     *
     * @return keys, the set containing all keys
     */
    @Override
    public Set<K> keySet() {
        // create a set to store the keys
        Set<K> keys = new HashSet<>();
        for (var pair : pairs) {
            if (pair != null && !pair.getKey().equals(new MapPaar().getKey())) {
                // get the current key
                K currKey = pair.getKey();
                // add to the set
                keys.add(currKey);
            }
        }
        // return the keys
        return keys;
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void printElements() {
        for (var pair : pairs) {
            if (pair != null) {
                System.out.println("Key: " + pair.getKey() + " Val: " + pair.getValue());
            } else {
                System.out.println("null item");
            }
        }
    }
}

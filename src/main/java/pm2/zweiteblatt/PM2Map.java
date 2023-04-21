package pm2.zweiteblatt;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author yunussozeri
 */
public class PM2Map<K, V> implements Map<K, V> {

    private MapPaar<K, V>[] pairs;
    private int length;
    private int cardinality;
    private MapPaar last;

    public PM2Map() {

    }

    public PM2Map(MapPaar<K, V>[] pairs) {
        this.pairs = pairs;
        length = 0;
        cardinality = 0;
    }

    @Override
    public int size() {
        return cardinality;
    }

    @Override
    public boolean isEmpty() {
        return cardinality == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (MapPaar pair : pairs) {
            if (pair != null) {
                if (pair.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MapPaar pair : pairs) {
            if (pair != null) {
                if (pair.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        V val = null;
        for (MapPaar pair : pairs) {
            if (pair != null) {
                if (pair.getKey().equals(key)) {
                    val = (V) pair.getValue();
                }
            }
        }
        return val;
    }

    @Override
    public V put(K key, V value) {
        // check size
        // increase size if needed
        
        // loop until last element
        // add new element to the next index
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        for (int i = 0; i < cardinality; i++) {
            pairs[i] = new MapPaar<K, V>();
        }
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

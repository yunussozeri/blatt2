
package pm2.zweiteblatt;

import java.util.Map;

/**
 *
 * @author yunussozeri
 */
public class MapPaar <K,V> implements Map.Entry<K, V>{

    private K key;
    private V value;
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
       V previous = this.value;
       this.value = (V) value;
       return previous;
    }
    
}

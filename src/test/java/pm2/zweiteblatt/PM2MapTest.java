
package pm2.zweiteblatt;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yunussozeri
 */
public class PM2MapTest {
    
    private  PM2Map testmap = new PM2Map();
    public PM2MapTest() {
       
    }

    /**
     * Test of size method, of class PM2Map.
     */
    @Test
    public void testSize() {
        int expResult = 10;
        testmap.put("A",1);
        testmap.put("B", 2);
        testmap.put("C",3);
        testmap.put("D", 4);
        testmap.put("E",5);
        testmap.put("F", 6);
        testmap.put("G",7);
        testmap.put("H", 8);
        testmap.put("I",9);
        testmap.put("J", 10);
        int result = testmap.size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isEmpty method, of class PM2Map.
     */
    @Test
    public void testIsEmpty() {
        
        
        boolean expResult = false;
        testmap.put("a", 1);
        boolean result = testmap.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of containsKey method, of class PM2Map.
     */
    @Test
    public void testContainsKeyNegative() {
        
        String key = "A";
        testmap.put("B",5);
        boolean expResult = false;
        boolean result = testmap.containsKey(key);
        assertEquals(expResult, result);
        
      
    }
    
    @Test
    public void testContainsKeyPositive() {
        
        String key = "A";
        testmap.put(key,0);
        boolean expResult = true;
        boolean result = testmap.containsKey(key);
        assertEquals(expResult, result);
          
    }

    /**
     * Test of containsValue method, of class PM2Map.
     */
    @Test
    public void testContainsValuePositive() {
        
        Integer value = 6;
        testmap.put("A",value);
        boolean expResult = true;
        boolean result = testmap.containsValue(value);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testContainsValueNegative() {
        
        Integer value = 5;
        testmap.put("A",6);
        boolean expResult = false;
        boolean result = testmap.containsValue(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class PM2Map.
     */
    @Test
    public void testGet() {
        
        String key = "A";
        Integer value = 5;
        testmap.put(key, value);
        Object expResult = 5;
        Object result = testmap.get(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class PM2Map.
     */
    @Test
    public void testPut() {
        
        String key = "A";
        Integer value = 1;
        testmap.put(key, value);
        assertEquals(value, testmap.put(key, 2));
    }

    /**
     * Test of remove method, of class PM2Map.
     */
    @Test
    public void testRemove() {
        
       String[] keyArr ={"A","yunus","oskar"};
        testmap.put(keyArr[0],1);
        testmap.put(keyArr[1],31);
        testmap.put(keyArr[2],32);
        
        testmap.remove(keyArr[0]);
        assertEquals(2, testmap.size());
        
    }
    
    @Test
    public void testRemoveAllByHand() {
        
       String[] keyArr ={"A","yunus","oskar"};
        testmap.put(keyArr[0],1);
        testmap.put(keyArr[1],31);
        testmap.put(keyArr[2],32);
        
        testmap.remove(keyArr[0]);
        testmap.remove(keyArr[1]);
        testmap.remove(keyArr[2]);
        
        assertEquals(0, testmap.size());
    }
    
    @Test
    public void testRemoveNonExistentKey() {
        
       String[] keyArr ={"A","yunus","oskar","Meine wille zum Leben"};
        testmap.put(keyArr[0],1);
        testmap.put(keyArr[1],31);
        testmap.put(keyArr[2],32);
        
        assertEquals(null, testmap.remove(keyArr[3]));
    }

    /**
     * Test of putAll method, of class PM2Map.
     */
    @Test
    public void testPutAll() {
        
        Map m = null;
        testmap.put("A", 5);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class PM2Map.
     */
    @Test
    public void testClear() {
        
        String[] keyArr ={"A","yunus","oskar"};
        testmap.put(keyArr[0],1);
        testmap.put(keyArr[1],31);
        testmap.put(keyArr[2],32);
        testmap.clear();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,testmap.size());
    }

    /**
     * Test of keySet method, of class PM2Map.
     */
    @Test
    public void testKeySet() {
        
        String[] keyArr ={"A","yunus","oskar"};
        testmap.put(keyArr[0],1);
        testmap.put(keyArr[1],31);
        testmap.put(keyArr[2],32);
        
        Set keys = testmap.keySet();
        
        assertEquals(true,keys.contains(keyArr[0]));
        assertEquals(true,keys.contains(keyArr[1]));
        assertEquals(true,keys.contains(keyArr[2]));

    }

    /**
     * Test of values method, of class PM2Map.
     */
    @Test
    public void testValues() {
       
//        PM2Map instance = null;
//        Collection expResult = null;
//        Collection result = instance.values();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of entrySet method, of class PM2Map.
     */
    @Test
    public void testEntrySet() {
        
       // PM2Map instance = null;
//        Set<Map.Entry<K, V>> expResult = null;
//        Set<Map.Entry<K, V>> result = instance.entrySet();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

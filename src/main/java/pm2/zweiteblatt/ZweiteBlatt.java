/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pm2.zweiteblatt;

import java.util.HashSet;

/**
 *
 * @author yunussozeri
 */
public class ZweiteBlatt {

    public static void main(String[] args) {
        PM2Map<String,Integer> map = new PM2Map<String,Integer>();
        
        MapPaar<String, Integer> m1 = new MapPaar<>("A",1);
        MapPaar<String, Integer> m2 = new MapPaar<>("B",2);
        MapPaar<String, Integer> m3 = new MapPaar<>("C",3);
        MapPaar<String, Integer> m4 = new MapPaar<>("D",4);
        
        map.put(m1.getKey(), m1.getValue());
        map.put(m2.getKey(), m2.getValue());
        map.put(m3.getKey(), m3.getValue());
        map.put(m4.getKey(), m4.getValue());
        
        map.put("A",5);
        map.put("F", 31);
        
        System.out.println(map.size());
        
        map.printElements();
        
        map.clear();
        System.out.println(map.size());
        
    }
}

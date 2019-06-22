/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sandeep.kumar
 */
public class ForEachEx {
    public static void main(String...args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 5);
        map.put("S", 3);
        map.put("D", 4);
        map.put("F", 1);
        map.put("G", 2);
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            return o1.getValue() - o2.getValue();
        });
        
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        list.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        //list.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
        
    }
}

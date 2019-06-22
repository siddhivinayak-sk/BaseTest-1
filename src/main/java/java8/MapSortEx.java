/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author sandeep.kumar
 */
public class MapSortEx {

    public static void main(String...args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 10);
        map.put("C", 8);
        map.put("B", 7);
        map.put("X", 9);
        map.put("V", 6);
        map.put("S", 4);
        map.put("T", 3);
        map.put("L", 1);
        map.put("M", 5);
        map.put("F", 2);
        map.put("G", 11);
        
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedMap);
        
        sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedMap);
        
        LinkedHashMap<String, Integer> sortedMap1 = new LinkedHashMap<String, Integer>();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(x -> sortedMap1.put(x.getKey(), x.getValue()));
        System.out.println(sortedMap1);
        
    }
}

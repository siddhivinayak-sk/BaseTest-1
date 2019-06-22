/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author sandeep.kumar
 */
public class MapFilterEx {

    public static void main(String...args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("X", 10);
        map.put("C", 15);
        map.put("V", 18);
        map.put("B", 19);
        map.put("N", 14);
        map.put("M", 12);
        map.put("I", 11);
        map.put("O", 17);
        map.put("P", 16);
        map.put("A", 13);
        
        String r1 = map.entrySet().stream().filter(entry -> entry.getKey().equals("A")).map(entry -> entry.getKey()).collect(Collectors.joining());
        System.out.println(r1);
        
        Map<String, Integer> r2 = map.entrySet().stream().filter(entry -> entry.getValue().equals(16)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(r2);
                
        String[][] strArr = new String[][] {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}, {"J", "K", "L"}, {"M", "N", "A"}};
        Stream<String[]> str1 = Arrays.stream(strArr);
        Stream<String> str2 = str1.flatMap(str -> Arrays.stream(str));
        str2.filter(str -> str.contains("A")).forEach(System.out::println);
        
        List<Student> sList = new ArrayList<Student>();
        Student s1 = new Student(1, "A", 9.0);
        Student s2 = new Student(2, "B", 9.3);
        sList.add(s1);
        sList.add(s2);
        s1.getBooks().add("Book 1");
        s1.getBooks().add("Book 2");
        s1.getBooks().add("Book 3");
        s1.getBooks().add("Book 4");
        s1.getBooks().add("Book 5");
        s1.getBooks().add("Book 5");
        s2.getBooks().add("Book 1");
        s2.getBooks().add("Book 2");
        s2.getBooks().add("Book 3");
        s2.getBooks().add("Book 4");
        s2.getBooks().add("Book 5");
        s2.getBooks().add("Book 5");
        
        List<String> bookList = sList.stream().map(ob -> ob.getBooks()).flatMap(obSet -> obSet.stream()).distinct().collect(Collectors.toList());
        System.out.println(bookList);
        
        int[] intArr = new int[] {0,9,8,7,1,2,3,4,6,8,7,6,8,5,4,6,5};
        Stream<int[]> intStr = Stream.of(intArr);
        IntStream intStream = intStr.flatMapToInt(ob -> Arrays.stream(ob));
        intStream.forEach(System.out::print);
        
        //Map to List
        List<String> keyList = map.keySet().stream().collect(Collectors.toList());
        List<Integer> valueList = map.values().stream().collect(Collectors.toList());
        
        List<String> r3 = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(e -> e.getKey())
                .filter(e -> e.contains("A"))
                .collect(Collectors.toList());
        System.out.println(r3);
        
        
        
                
    }
}

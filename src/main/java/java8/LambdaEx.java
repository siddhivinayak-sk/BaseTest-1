/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sandeep.kumar
 */
public class LambdaEx {
    
    public static void main(String...args) {
        List<String> list = new ArrayList<>();
        list.add("X");
        list.add("Z");
        list.add("A");
        list.add("Y");
        list.add("P");
        list.add("B");
        list.add("M");
        list.add("R");
        list.add("T");
        list.add("S");
 
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        list.sort((String s1, String s2) -> s1.compareTo(s2));

        list.sort((s1, s2) -> s2.compareTo(s1));

        list.sort((s1, s2) -> {return s2.compareTo(s1);});
        
        list.forEach(System.out::println);
        
    }
    
}





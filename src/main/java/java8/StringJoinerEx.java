/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 *
 * @author sandeep.kumar
 */
public class StringJoinerEx {
    public static void main(String...args) {
        StringJoiner sj1 = new StringJoiner("','", "('", "')");
        sj1.add("a");
        sj1.add("b");
        sj1.add("c");
        sj1.add("d");
        System.out.println(sj1);
        
        String r1 = String.join(",", "a", "b", "c", "d");
        System.out.println(r1);
        
        List<String> st1 = Arrays.asList("a", "b", "c", "d");
        String r2 = String.join("-", st1);
        System.out.println(r2);
        
        String r3 = st1.stream().collect(Collectors.joining("','", "('", "')"));
        System.out.println(r3);
        
        List<Employee> st2 = Arrays.asList(new Employee(1L, "A", 99D), new Employee(6L, "F", 97D), new Employee(3L, "B", 99D), new Employee(5L, "D", 95D), new Employee(9L, "S", 98D));
        String r4 = st2.stream().map(ob -> ob.getName()).collect(Collectors.joining("','", "('", "')"));
        System.out.println(r4);
        
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author sandeep.kumar
 */
public class JoinArraysEx {
    public static void main(String...args) {
        String[] s1 = new String[]{"a", "b", "c", "d"};
        String[] s2 = new String[]{"e", "f", "g", "h"};
        String[] s3 = new String[]{"i", "j", "k", "l"};
        
        String[] r1 = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
        Stream.of(r1).forEach(System.out::print);
        System.out.println("");
        
        int[] a1 = new int[] {1,2,3,4};
        int[] a2 = new int[] {5,6,7,8};
        int[] a3 = new int[] {9,10,11,12};
        
        int[] r2 = IntStream.concat(Arrays.stream(a1), IntStream.concat(Arrays.stream(a2), Arrays.stream(a3))).toArray();
        Arrays.stream(r2).forEach(System.out::print);
        System.out.println("");
        
        String example = "abcdefghijklmnopqrstuvwxyz";
        example.chars().mapToObj(ob -> (char)ob).forEach(System.out::print);
        
        System.out.println("");
        int[] a4 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<Integer> iList1 = Arrays.stream(a4).mapToObj(ob -> (int)ob).collect(Collectors.toList());
        List<Integer> iList2 = Arrays.stream(a4).boxed().collect(Collectors.toList());
        List<Integer> iList3 = IntStream.of(a4).boxed().collect(Collectors.toList());
                
        iList1.stream().forEach(System.out::print);
        System.out.println("");
        
        //Check if value contains in array
        boolean f1 = Arrays.stream(a4).anyMatch(ob -> ob == 1);
        System.out.println(f1);
        
        String sa[] = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        boolean f2 = Arrays.stream(sa).anyMatch("a"::equals);
        System.out.println(f2);
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sandeep.kumar
 */
public class StreamReadFileEx {
    public static void main(String...args) {
        /*
        try (Stream<String> st1 = Files.lines(Paths.get("d:/test/6/A.java"))) {
            st1.map(ob -> "Line: " +ob).forEach(System.out::println);
        }
        catch(IOException ioe) {}
        */
        
        try (BufferedReader br = Files.newBufferedReader(Paths.get("d:/test/6/A.java"))) {
            List<String> data = br.lines().collect(Collectors.toList());
            data.stream().forEach(System.out::println);
        }
        catch(IOException ioe) {}
    }
}

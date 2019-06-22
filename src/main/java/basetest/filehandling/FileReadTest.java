/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.filehandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sandeepkumar
 */
public class FileReadTest {
    
    public static void main(String...args) throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\sandeepkumar\\Desktop\\Docs\\F1\\aaa.txt"));
        String str = "";
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null) {
            sb.append(str);
            sb.append("\n");
        }
        
        Files.write(Paths.get("C:\\Users\\sandeepkumar\\Desktop\\Docs\\F1\\aaa_1.txt"), sb.toString().replaceAll("\\u001F", "").getBytes("utf-8"), StandardOpenOption.CREATE);
        
        Matcher matcher = Pattern.compile(".").matcher(sb);
        while(matcher.find()) {
            char[] c = matcher.group().toCharArray();
            int x = c[0];
            System.out.println(c[0] + " = " + x);
        }
        
    }
    
}

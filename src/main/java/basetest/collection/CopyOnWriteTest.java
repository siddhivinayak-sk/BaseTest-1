/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.collection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author sandeepkumar
 */
public class CopyOnWriteTest {
    
    /**
     *
     * @param args
     */
    public static void main(String...args) {
        CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<String> s = new CopyOnWriteArraySet<>();
        
        Runnable r1 = () -> {
            for(int i = 0; i < 100; i++) {
                al.add(i + "");
            }
        };

        Runnable r2 = () -> {
            for(int i = 0; i < 100; i++) {
                s.add(i + "");
            }
        };
        
        Runnable r3 = () -> {
            ListIterator<String> lit = al.listIterator();
            Iterator<String> it = s.iterator();
            
            while(lit.hasNext()) {
                lit.remove();
                System.out.println(lit.next());
            }
            while(it.hasNext()) {
                System.out.println(it.next());
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        Thread t3 = new Thread(r2);
        Thread t4 = new Thread(r2);

        Thread t5 = new Thread(r3);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author sandeepkumar
 */
public class AtomicCounter {

    //With AtomicInteger Counter

    /**
     *
     * @param args
     */
    public static void main1(String...args) {
        AtomicInteger counter = new AtomicInteger();
        Runnable r = () -> {
            for(int i = 0; i < 1000;i++) 
                counter.incrementAndGet();
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(Exception e) {e.printStackTrace();}
        System.out.println(counter.intValue());
    }

    //Without AtomicInteger Counter

    /**
     *
     * @param args
     */
    public static void main(String...args) {
        class Counter {
            int counter;
            public void increment() {
                counter++;
            }
            public int getValue() {
                return counter;
            }
        }
        Counter counter = new Counter();
        Runnable r = () -> {
            for(int i = 0; i < 1000;i++) 
                counter.increment();
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(Exception e) {e.printStackTrace();}
        System.out.println(counter.getValue());
    }

}


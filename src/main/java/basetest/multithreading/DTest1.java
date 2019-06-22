/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

/**
 *
 * @author sandeepkumar
 */
public class DTest1 {
    public static void main(String...args) {
        String resourceA = new String("A");
        String resourceB = new String("A");
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized(resourceA) {
                    try { Thread.sleep(1000);} catch(Exception e) {e.printStackTrace();}
                    synchronized(resourceB) {
                        System.out.println("A");
                    }
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized(resourceB) {
                    try { Thread.sleep(1000);} catch(Exception e) {e.printStackTrace();}
                    synchronized(resourceA) {
                        System.out.println("A");
                    }
                }
            }
        });
        
        t1.start();
        t2.start();
    }
}

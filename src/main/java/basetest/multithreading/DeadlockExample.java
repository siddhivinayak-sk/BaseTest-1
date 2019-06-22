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
public class DeadlockExample {
    
    /**
     *
     * @param args
     */
    static public void main(String...args) {
        final String resourceA = new String("A");
        final String resourceB = new String("B");
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(resourceA) {
                    System.out.println("Locked: A    Thread: T1");
                    try { Thread.sleep(3000); } catch(InterruptedException e) {e.printStackTrace();}
                    synchronized(resourceB) {
                        System.out.println("Locked: B    Thread: T1");
                        System.out.println(resourceA);
                    }
                }
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(resourceB) {
                    System.out.println("Locked: B    Thread: T2");
                    try { Thread.sleep(3000); } catch(InterruptedException e) {e.printStackTrace();}
                    synchronized(resourceA) {
                        System.out.println("Locked: A    Thread: T1");
                        System.out.println(resourceB);
                    }
                }
            }
        }, "T1");
        t1.start();
        t2.start();
    }
}

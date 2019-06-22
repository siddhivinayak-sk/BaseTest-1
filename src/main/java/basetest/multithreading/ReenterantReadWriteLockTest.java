/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandeepkumar
 */
public class ReenterantReadWriteLockTest {

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String...args) throws InterruptedException {
        ReadWriteArrayList<String> arr = new ReadWriteArrayList<>();
        
        Runnable r1 = () -> {
            for(int i = 0; i< 100; i++) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
                Random random = new Random();
                arr.add(Thread.currentThread().getName() + ":" + (i + 1) + ":" + random.nextInt());
            }
        };
        Runnable r2 = () -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
            arr.read();
        };
        
        new Thread(r1).start();
        new Thread(r1).start();

        new Thread(r2).start();
    }


    static class ReadWriteArrayList<T> {
        private ArrayList<T> list;
        private ReentrantReadWriteLock lock;
        
        {
            lock = new ReentrantReadWriteLock();
            list = new ArrayList<T>();
        }
        
        public boolean add(T t) {
            lock.writeLock().lock();
            boolean result = list.add(t);
            lock.writeLock().unlock();
            return result;
        }
        
        public void read() {
            lock.readLock().lock();
            for(T t:list) {
                System.out.println(t);
            }
            lock.readLock().unlock();
        }
    };
}

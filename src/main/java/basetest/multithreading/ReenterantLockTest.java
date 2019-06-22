/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author sandeepkumar
 */
public class ReenterantLockTest {

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    static public void main(String...args) throws InterruptedException {
        final Account ac = new Account();

        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Runnable wR = () -> { ac.withdrawal(10, lock, condition); };
        Runnable dR = () -> { ac.deposite(100, lock, condition); };

        for(int i = 0; i < 10; i++) {
            Thread t = new Thread(wR);
            t.start();
        }

        Thread.sleep(5000);
        
        Thread dt = new Thread(dR);
        dt.start();
    }

    static class Account {
        private double balance;
        
        public void deposite(double value, Lock lock, Condition condition) {
            boolean isLock = lock.tryLock();
            try {
                balance += value;
                System.out.println("D:" + Thread.currentThread().getName() + ":" + value + ":" + balance);
                condition.signalAll();
            }
            finally {
                if(isLock) {
                    lock.unlock();
                }
            }
        }
        
        public void withdrawal(double value, Lock lock, Condition condition) {
            boolean isRun = true;
            lock.lock();
            try {
                while(isRun) {
                    if(balance >= value) {
                        balance -= value;
                        System.out.println("W:" + Thread.currentThread().getName() + ":" + value + ":" + balance);
                        isRun = false;
                    }
                    else {
                        System.out.println("Waiting:W:" + Thread.currentThread().getName() + ":" + value + ":" + balance);
                        try {
                            condition.await();
                        }
                        catch(InterruptedException | IllegalMonitorStateException ie) {
                            ie.printStackTrace(); 
                        }
                    }
                }
            }
            finally {
                lock.unlock();
            }
        }
    }
}


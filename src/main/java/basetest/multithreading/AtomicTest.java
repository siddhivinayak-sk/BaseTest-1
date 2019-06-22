/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

/**
 *
 * @author sandeepkumar
 */
public class AtomicTest {

    /**
     * @param XXX  This is an example
     * @param args
     */
    public static void main(String...args) {
        Account ac = new Account();
        ac.deposite(50);
        Runnable r1 = () -> {
            for(int i = 0; i < 5; i++)
                ac.withdrawal(10);
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(Exception e) {e.printStackTrace();}
    }
}

class Account {
    private AtomicInteger balance;

    public Account() {
        balance = new AtomicInteger();
    }
    
    public boolean deposite(Integer amount) {
        balance.addAndGet(amount);
        return true;
    }
    
    public boolean withdrawal(Integer amount) {
        IntBinaryOperator io = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                String threadName = Thread.currentThread().getName();
                //System.out.println(threadName + ":W:S " + left);
                if(left >= right) {
                    System.out.println(threadName + ":W " + left);
                    left = left - right;
                }
                //System.out.println(threadName + ":W:E " + left);
                return left;
            }
        };
        balance.accumulateAndGet(amount, io);
        return true;
    }
}

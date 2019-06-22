/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/**
 *
 * @author sandeepkumar
 */
public class InterThreadCommunicationExample {
    
    /**
     *
     * @param args
     */
    static public void main(String...args) {
        final Account a1 = new Account();
        for(int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a1.withdrawal(5);
                }
            }, "T" + i).start();
        }
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    while(true) {
                        String line = br.readLine();
                        if(line.equalsIgnoreCase("exit")) {
                            br.close();
                            System.exit(0);
                        }
                        double balance = 0;
                        try {balance = Double.parseDouble(line);} catch(NumberFormatException e) {e.printStackTrace();}
                        a1.deposite(balance);
                    }
                }
                catch(IOException i0e) {
                    i0e.printStackTrace();
                }
            }
        }, "Deposite Thread").start();
    }
    
    
    
    

    static class Account {
        private double balance;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
        
        public void deposite(double balance) {
            System.out.println("Balance Deposite: " + balance);
            synchronized(this) {
                this.balance = this.balance + balance;
                this.notifyAll();
            }
        }
 
        //The wait() method must be called when lock of object is obtained otherwise IlligalMoniterStateException; however, notify(), notifyAll() may be outside synchronized area
        public boolean withdrawal(double balance) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread Name: " + threadName + "   Initiate Withdrawal: Current Balance: " + getBalance() + " Withdrawal Amount: " + balance);
            boolean result = false;
            synchronized(this) {
                while(result == false) {
                    if(getBalance() >= balance) {
                        setBalance(getBalance() - balance);
                        result = true;
                        System.out.println("Thared Name: " + threadName + "    Sufficient balance...Transaction success!");
                    }
                    else {
                        System.out.println("Thared Name: " + threadName + "    Low balance...Transaction went into Blocked state!");
                        try {this.wait();} catch(Exception e) { e.printStackTrace(); }
                        System.out.println("Thared Name: " + threadName + "    Balance recovered...Transaction success!");
                    }
                }
            }
            System.out.println("Thared Name: " + threadName + "      End Withdrawal: Current Balance: " + getBalance() + " Withdrawal Amount: " + balance);
            return result;
        }
    }
    
}

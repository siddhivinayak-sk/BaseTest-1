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
public class RaceConditionExample {
    
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
            this.balance = this.balance + balance;
        }
 
        /* To solve Race-Condition add synchronization */
        synchronized 
        public boolean withdrawal(double balance) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread Name: " + threadName + "   Initiate Withdrawal: Current Balance: " + getBalance() + " Withdrawal Amount: " + balance);
            boolean result;
            if(getBalance() >= balance) {
                try {
                    Thread.sleep(2000);
                }
                catch(Exception e) { e.printStackTrace(); }
                setBalance(getBalance() - balance);
                result = true;
                System.out.println("Sufficient balance...Transaction success!");
            }
            else {
                result = false;
                System.out.println("Low balance...Transaction failed!");
            }
            System.out.println("End Withdrawal: Current Balance: " + getBalance() + " Withdrawal Amount: " + balance);
            return result;
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String...args) {
        final Account a1 = new Account();
        a1.setBalance(20);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                    a1.withdrawal(10);
                }
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                    a1.withdrawal(10);
                }
            }
        }, "T2");
        t1.start();
        t2.start();
    }
}

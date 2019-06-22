package basetest.multithreading;

import java.util.concurrent.Exchanger;

/**
 * Exchanger: It is a synchronization tool where some data is exchanged between
 * two threads on certain point of execution. If any one of thread reached to
 * the exchange point it waits for other thread to reach as same exchange point.
 * It has an overloaded exchange method which takes time limit as argument and
 * waits till specified time, if other thread does not reach within specified
 * time limit, it throws java.util.concurrent.TimeoutException.
 * 
 * If specified time is less than 0 or 0, it does not wait for other thread.
 * 
 * The Exchanger has been designed using generic structure so it can return any
 * type of values, and we can restrict return type by putting generic
 * declaration.
 * 
 * The Exchanger is designed to exchange data between two threads only, if
 * more threads needs to part in exchanging, SynchronousQueue could be used.
 * 
 */
public class ExchangerEx {
    private final Exchanger<String> exchanger;
    
    private ExchangerEx() {
        exchanger = new Exchanger<>();
    }
    
    private class Producer implements Runnable {
        public void run() {
            try {
                String queue = exchanger.exchange("Ready Queue");
                System.out.println(Thread.currentThread().getName() + ": " + queue);
            }
            catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
    
    private class Consumer implements Runnable {
        public void run() {
            try {
                String queue = exchanger.exchange("Empty Queue");
                System.out.println(Thread.currentThread().getName() + ": " + queue);
            }
            catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static void main(String...args) {
        ExchangerEx ex = new ExchangerEx();
        new Thread(ex.new Producer(), "Producer").start();
        new Thread(ex.new Consumer(), "Consumer").start();
    }
}

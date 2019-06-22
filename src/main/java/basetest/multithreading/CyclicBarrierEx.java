package basetest.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier: It is a class defined in java.util.concurrent package to
 * provide another kind of happen-before tooling. CyclicBarrier is useful when
 * there is a requirement of stop/start execution of multiple thread from
 * common execution point/trigger point/barrier. The trigger point is defined inside
 * thread by using await() method. When we create CyclicBarrier, a number is
 * passed into the constructor which specifies that the trigger point invoked
 * when specified number of thread call await() method.
 * When code find await() method called on CyclicBarrier, it halts the execution
 * of thread; when the calling await() method reaches to specified number 
 * (defined in CyclicBarrier constructor) then all threads are signaled to
 * continue their processing.
 * 
 */
public class CyclicBarrierEx {
    
    public static void main(String...args) throws InterruptedException {
        int[][] data = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0},
            {0, 3, 1, 3, 4, 5, 6, 7, 8, 9, 0},
            {4, 4, 4, 2, 1, 1, 1, 3, 1, 1, 0},
            {4, 6, 3, 1, 2, 8, 3, 1, 4, 9, 0},
            {5, 7, 8, 5, 3, 6, 4, 7, 8, 7, 0},
            {8, 8, 0, 7, 6, 2, 6, 5, 9, 6, 0},
            {0, 1, 1, 8, 7, 3, 8, 3, 2, 4, 0},
            {2, 5, 3, 0, 8, 4, 9, 1, 5, 2, 0},
            {1, 0, 0, 1, 9, 8, 1, 0, 6, 1, 0},
            {8, 8, 9, 6, 0, 9, 0, 9, 1, 9, 0}
        };
        
        CyclicBarrierEx ex = new CyclicBarrierEx(data);
        Thread.sleep(5000);
        System.out.println(sb.toString());
    }
    
    
    private int[][] data;
    private CyclicBarrier cb;
    
    public CyclicBarrierEx(int[][] data) {
        this.data = data;
        int parties = data.length;
        cb = new CyclicBarrier(parties, new Runnable(){
            public void run() {
                int total = 0;
                for(int i = 0; i < parties; i++) {
                    total += CyclicBarrierEx.this.data[parties -1][10];
                }
                print("Total: " + total);
            }
        });
        for(int i = 0; i < parties; i++) {
            new Thread(new Worker(i)).start();
        }
    }
    
    class Worker implements Runnable {
        final private int rowNum;
        public Worker(int rowNum) {
            this.rowNum = rowNum;
        }
        public void run() {
            print("_______________________Start DoTask " + rowNum + "_______________________");
            doTask(rowNum);
            try {
                print(rowNum + ": " + "Start Waiting");
                cb.await();
                print(rowNum + ": " + "Woke up");
            }
            catch(InterruptedException | BrokenBarrierException ie) {
                ie.printStackTrace();
            }
            print("_______________________End DoTask " + rowNum + "  _______________________");
        }
    }
    
    public void doTask(int rowNum) {
        int total = 0;
        for(int i = 0; i < 10; i++) {
            total += data[rowNum][i];
        }
        print(rowNum + " - Total: " + total);
    }

    private static StringBuilder sb = new StringBuilder();
    public synchronized void print(Object ob) {
        sb.append(ob);
        sb.append("\n");
    }
    
}

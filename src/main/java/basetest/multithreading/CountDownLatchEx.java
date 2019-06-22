package basetest.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CountDownLatch: CountDownLatch is a class in java.util.concurrent package
 * which provides a feature to wait one or more thread until a set of operation
 * being performed. Here, two methods are mainly used await() and countDown();
 * await() method blocks the processing and countDown() method decrease the
 * count to down by 1, when count down reaches 0, it starts execution of blocked
 * statements. The counter cannot be reset, if counter needs to reset use
 * CyclicBarrier class instead.
 * 
 * 
 */
public class CountDownLatchEx {
    public static void main(String...args) throws Exception {
        CountDownLatchEx ex = new CountDownLatchEx();
        ex.example1();
    }

    public void example1() throws InterruptedException {
        List<Future> fList = new ArrayList<Future>();
        CountDownLatch cdl1 = new CountDownLatch(4); //CountDownLatch created with count 4
        ExecutorService es = Executors.newFixedThreadPool(5); //Cretaed ThreadPool of size 5 to execute 5 threads
        for(int i = 1; i <= 5; i++) {
            Future f = es.submit(new Work(cdl1, (i+ 1))); //Submissiion of Runnables into ThreadPool to execute
            fList.add(f);
        }
        cdl1.await(); //It will wait to complete the task of ThreadPool to compele and then execute next line
        System.out.println("Rest of task(s) being executed...");
        
        //Initiate shutdown when all task executed
        while(true) {
            boolean isAllTaskCompleted = true;
            for(Future f:fList) {
                if(!f.isDone()) {
                    isAllTaskCompleted = false;
                }
            }
            if(isAllTaskCompleted) {
                es.shutdown();
                break;
            }
        }
    }
    class Work implements Callable<Integer> {
        final private CountDownLatch cdl;
        final private int i;
        public Work(CountDownLatch cdl, int i) {
            this.cdl = cdl;
            this.i = i;
        }
        public Integer call() {
            doWork(i);
            System.out.println("Do Work - " + Thread.currentThread().getName() + ": " + i);
            cdl.countDown(); //Count downs each time when task executed
            return 0;
        }
        void doWork(int i) {
            try {
                Thread.sleep(i * 1000);
            }
            catch(InterruptedException ie) {}
        }
    }
}

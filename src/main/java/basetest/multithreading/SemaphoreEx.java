package basetest.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Semaphore: A Semaphore is counter on synchronized shared resource which is
 * used to control the access of shared resource. It has mainly two methods i.e.
 * acquire() and release(); acquire() checks whether semaphore counter is > 0,
 * it permits access and decrease counter by 1, if counter is 0 then, thread is
 * send for waiting till counter is greater than 0.
 * 
 * the second method, release() denotes the shared resource has been released
 * for waiting threads and increases the semaphore counter by 1. And, signals to
 * all waiting threads for permit.
 */
public class SemaphoreEx {
    
    public static void main(String...args) throws InterruptedException {
        SemaphoreEx ex = new SemaphoreEx();
        Resource r = ex.new Resource("Resource 1");
        
        Semaphore s = new Semaphore(1);
        
        Thread t1 = new Thread(ex.new MyTask(s, r), "A");
        Thread t2 = new Thread(ex.new MyTask(s, r), "B");
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Counter: " + r.getCounter());
    }
    
    
    private class MyTask implements Runnable {
        private Semaphore semaphore;
        private Resource resource;
        
        public MyTask(Semaphore semaphore, Resource resource) {
            this.semaphore = semaphore;
            this.resource = resource;
        }
        
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread: " + threadName);
            if("A".equalsIgnoreCase(threadName)) {
                System.out.println(threadName + " is waiting for permit");
                try {
                    semaphore.acquire();
                    System.out.println(threadName + " is gets a permit");
                    for(int i = 0; i < 5; i++) {
                        resource.increment();
                        System.out.println(threadName + " Count: " + resource.getCounter());
                        Thread.sleep(10);
                    }
                }
                catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(threadName + " releases permit");
                semaphore.release();
            }
            else {
                System.out.println(threadName + " is waiting for permit");
                try {
                    semaphore.acquire();
                    System.out.println(threadName + " is gets a permit");
                    for(int i = 0; i < 5; i++) {
                        resource.decrement();
                        System.out.println(threadName + " Count: " + resource.getCounter());
                        Thread.sleep(10);
                    }
                }
                catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(threadName + " releases permit");
                semaphore.release();
            }
        }
    }
    
    private class Resource {
        private String name;
        private int counter;
        public Resource() {}
        public Resource(String name) {
            this.name = name;
        }
        public void increment() {
            counter++;
        }
        public void decrement() {
            counter--;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }
}

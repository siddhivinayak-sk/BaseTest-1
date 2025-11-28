package basetest.multithreading.virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Virtual Thread (VT) is a new feature in Java 17. It is a lightweight thread that is managed by the JVM (instead of OS
 * thread which takes 2MB memory at least and managed by OS).
 * The JVM creates an OS thread and then creates multiple virtual threads on top of it. The JVM schedules the virtual
 * threads on the OS thread.
 */
public class BasicVirtualThreadTest {

    void start() throws Exception{

        // 1. Create a virtual thread using ofVirtual() method
        Thread thread1 = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual Thread");
        });
        System.out.println(thread1.isVirtual());
        thread1.join();

        // 2. Create a virtual thread using Thread.Builder
        Thread.Builder threadBuilder1 = Thread.ofVirtual().name("Worker-0");
        Runnable task1 = () -> {
            Thread currentThread = Thread.currentThread();
            var threadId = currentThread.threadId();
            System.out.println("==========Task 1============");
            System.out.println(threadId + ": Thread Id: " + threadId);
            System.out.println(threadId + ": Thread Name: " + currentThread.getName());
            System.out.println(threadId + ": Is Virtual: " + currentThread.isVirtual());
            System.out.println(threadId + ": Is Daemon: " + currentThread.isDaemon());
            System.out.println(threadId + ": Is Alive: " + currentThread.isAlive());
            System.out.println(threadId + ": Is Interrupted: " + currentThread.isInterrupted());
            System.out.println(threadId + ": Thread Group: " + currentThread.getThreadGroup());
            System.out.println(threadId + ": Thread Priority: " + currentThread.getPriority());
            System.out.println(threadId + ": Thread State: " + currentThread.getState());
        };
        Thread thread2 = threadBuilder1.start(task1);
        Thread thread3 = threadBuilder1.start(task1);
        thread2.join();
        thread3.join();

        // 3. Create a virtual thread using ExecutorService
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = executorService.submit(task1);
            System.out.println(future.get());
        }

    }




    public static void main(String...args) throws Exception {
        BasicVirtualThreadTest basicVirtualThreadTest = new BasicVirtualThreadTest();
        basicVirtualThreadTest.start();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.multithreading;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sandeepkumar
 */
public class ExectutorTesting {
    
    /**
     *
     */
    public void go() {
        Callable callable1 = new Callable() {
            @Override
            public Integer call() throws Exception {
                int current = ThreadLocalRandom.current().nextInt(0, 15);
                for(int i = 0; i < current; i++) {
                    System.out.println(new Date() + ":" + Thread.currentThread().getName() + ": " + i);
                }
                return current;
            }
        };
        
        /**
         * Creates a thread pool that creates new threads as needed, but
         * will reuse previously constructed threads when they are
         * available.
         * - Threads are created and placed in pool, and it reuses the previously
         * created thread
         * - It is good for short life task
         * - Only when no threads are available in pool, new Thread is created
         * - Thread that was not used since last 60 seconds are terminated and
         * removed from the pool. Hence a pool which has not been used long 
         * enough will not consume any resources
         * - Object of ThreadPoolExecutor returned
         */
        /*
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<Integer> f1 = cachedThreadPool.submit(callable1);
        Future<Integer> f2 = cachedThreadPool.submit(callable1);
        Future<Integer> f3 = cachedThreadPool.submit(callable1);
        Future<Integer> f4 = cachedThreadPool.submit(callable1);
        Future<Integer> f5 = cachedThreadPool.submit(callable1);
        try {System.out.println("Future F1: " + f1.get());}catch(InterruptedException | ExecutionException ie) {ie.printStackTrace();}
        try {System.out.println("Future F2: " + f2.get());}catch(InterruptedException | ExecutionException ie) {ie.printStackTrace();}
        try {System.out.println("Future F3: " + f3.get());}catch(InterruptedException | ExecutionException ie) {ie.printStackTrace();}
        try {System.out.println("Future F4: " + f4.get());}catch(InterruptedException | ExecutionException ie) {ie.printStackTrace();}
        try {System.out.println("Future F5: " + f5.get());}catch(InterruptedException | ExecutionException ie) {ie.printStackTrace();}
        try {Thread.sleep(5000);}catch(Exception e) {e.printStackTrace();}        
        try {
            cachedThreadPool.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        finally {
            if(!cachedThreadPool.isTerminated()) {
                List<Runnable> aliveRunnable = cachedThreadPool.shutdownNow();
                if(null != aliveRunnable && !aliveRunnable.isEmpty()) {
                    for(Runnable runnable:aliveRunnable) {
                        System.out.println(runnable);
                    }
                }
            }
        }
        */
        
        
        
        /**
         * Creates a Executor with single worker that means only one thread can
         * be created at a time. Once current running thread gets completed the
         * next one will be picked up for running.
         * So it is also equivalent to FixedThreadPool with size 1
         *  - Object of ThreadPoolExecutor returned
         */
        /*
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        Future<Integer> f6 = singleThread.submit(callable1);
        Future<Integer> f7 = singleThread.submit(callable1);
        try {Thread.sleep(50);}catch(Exception e) {e.printStackTrace();}
        if(f6.isDone()) {
            try {
                System.out.println("F6 Done : " + f6.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F6 is still not Done");
        }
        if(f7.isDone()) {
            try {
                System.out.println("F7 Done : " + f7.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F7 is still not Done");
        }
        try {Thread.sleep(1000);}catch(Exception e) {e.printStackTrace();}
        singleThread.shutdown();
        */
        
        
        
        /**
         * It creates a thread pool with defined size so, number of maximum
         * concurrently threads depends on the sized of the pool. If too many
         * Callable are submitted to execute, they will wait for the earlier
         * threads to complete and get space in pool.
         * - Try to put the size of pool same as the available processors
         * - It is best for long running tasks so that overload on resource can
         * not be made
         *  - Object of ThreadPoolExecutor returned
         */
        /*
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Integer> f8 = fixedThreadPool.submit(callable1);
        Future<Integer> f9 = fixedThreadPool.submit(callable1);
        Future<Integer> f10 = fixedThreadPool.submit(callable1);
        Future<Integer> f11 = fixedThreadPool.submit(callable1);
        Future<Integer> f12 = fixedThreadPool.submit(callable1);
        try {Thread.sleep(50);}catch(Exception e) {e.printStackTrace();}
        if(f8.isDone()) {
            try {
                System.out.println("F8 Done : " + f8.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F8 is still not Done");
        }
        if(f9.isDone()) {
            try {
                System.out.println("F9 Done : " + f9.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F9 is still not Done");
        }
        if(f10.isDone()) {
            try {
                System.out.println("F10 Done : " + f10.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F10 is still not Done");
        }
        if(f11.isDone()) {
            try {
                System.out.println("F11 Done : " + f11.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F11 is still not Done");
        }
        if(f12.isDone()) {
            try {
                System.out.println("F12 Done : " + f12.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F12 is still not Done");
        }
        fixedThreadPool.shutdown();
        */
        
        /**
         * It creates ScheduledExecutor with bounded pool size with 1. By using 
         * this object, a thread can be scheduled in three ways:
         * 1. Scheduled with fixed delay, it will invoke the thread after the 
         * specified delay lapsed just like timer.
         * 2. Scheduled to execute with fixed rate of specified time value
         * 3. Scheduled to execute with fixed delay like Timer
         * 
         * - Create Single threaded Scheduled executor
         */
        /*
        ScheduledExecutorService singleThreadSheduled = (ScheduledExecutorService)Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<Integer> f13 = singleThreadSheduled.schedule(callable1, 5, TimeUnit.SECONDS);
        ScheduledFuture f14 = singleThreadSheduled.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    System.out.println("F14");
                    callable1.call();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2, 5, TimeUnit.SECONDS);
        ScheduledFuture f15 = singleThreadSheduled.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                try {
                    System.out.println("F15");
                    callable1.call();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2, 5, TimeUnit.SECONDS);
        if(f13.isDone()) {
            try {
                System.out.println("F13 Done : " + f13.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F13 is still not Done");
        }
        if(f14.isDone()) {
            try {
                System.out.println("F14 Done : " + f14.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F14 is still not Done");
        }
        if(f15.isDone()) {
            try {
                System.out.println("F15 Done : " + f15.get());
            }
            catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("F15 is still not Done");
        }
        singleThreadSheduled.shutdown();
        */
        
        /**
         * It provides ScheduledThreadExecutor with specified corePoolSize that
         * lets multiple thread running asynchronously. The type of scheduling
         * of thread can be created as for fixed delay (one time execution),
         * for fixed rate delay (multiple time execution) and lastly, for fixed
         * rate delay (multiple time execution).
         * There is basic difference between fixed rate and fixed delay. Suppose
         * we have to execute a task for 1 hour fixed rate/delay and task takes
         * 10 minutes to completed then the below can be achieved:
         * With fixed Rate:
            00:00: Start
            00:10: Finish
            01:00: Start
            01:10: Finish
            02:00: Start
            02:10: Finish
         * 
         * With fixed Delay:
            00:00: Start
            00:10: Finish
            01:10: Start
            01:20: Finish
            02:20: Start
            02:30: Finish
         * 
         * 
         */
        /*
        ScheduledExecutorService sheduledThreadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        ScheduledFuture<Integer> f16 = sheduledThreadPool.schedule(callable1, 5, TimeUnit.SECONDS);
        try {
            Thread.sleep(6000);
            if(f16.isDone()) {
                System.out.println("F16: " + f16.get());
            }
            else {
                System.out.println("WF16");
            }
        }
        catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        ScheduledFuture f17 = sheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    callable1.call();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2, 5, TimeUnit.SECONDS);
        ScheduledFuture f18 = sheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                try {
                    callable1.call();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2, 5, TimeUnit.SECONDS);
        sheduledThreadPool.shutdown();
        */

        
        /**
         * It returns object of ForkJoinPool which could be used for work
         * stealing and divide and conquer concept for processing of large
         * task. Here, a large task is divided into small chunks and processed
         * these chunks separately in distinct thread, it any thread completes
         * their own task, then CPU core is made free to steal some task from 
         * the slower Thread.
         */
        ForkJoinPool parellelThreadPool = (ForkJoinPool)Executors.newWorkStealingPool();
        
        
        
        
        
        /**
         * ForkJoinPool works on the basis of Divide and Conquer technique, in
         * which a large task is sub-divided into small chunks, processed
         * in parallel manner and finally, all processed result is added to make
         * final result.
         * ForkJoin can be implemented by RecursiveAction and RecursiveTask.
         * Both classes RecursiveAction and RecursiveTask extends ForkJoinTask
         * and could be used in different scenario and to represent any task,
         * any one of both classes must be extended.
         * - RecursiveAction: It could be used when there is no return value of
         * running task.
         * - RecursiveTask: It could be used when task has to return value when
         * it completes.
         * 
         * ForkJoin has mainly four methods used to do ForkJoin:
         * - fork(): It indicates task is forked and made left wing.
         * - compute(): Basically, this method does the task sole work and this
         * must be override when custom task is created by extending
         * RecursiveAction or RecursiveTask.
         * - join(): It holds the left slice and wait for right to complete. If
         * right completes before it's calling, it just ensure the right has 
         * completed success fully.
         * - invokeAll(ForkJoinTask t1, ForkJoinTask t2): It is basically short
         * cut for the fork(), compute() and join(). It could be used to save
         * typing of code.
         * 
         * Here, left or right task wing represents the forked/sliced chunks of
         * a big task which has been sliced into two part from the middle.
         * 
         */
        /**/
        Integer[] data = new Integer[100_000_000];
        long startTime = 0, endTime = 0;
        
        System.out.println("Time Analysis:Normally:Start");
        //Init Array
        startTime = System.currentTimeMillis();
        for(int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time Taken in Init Normally: " + (endTime - startTime));
 
        //Iterate and find max
        startTime = System.currentTimeMillis();
        int max = -1;
        for(int ix = 0; ix < data.length; ix++) {
            if(data[ix] > max) {
                max = data[ix];
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time tasken " + (endTime - startTime));
        System.out.println("Value" + max);
        System.out.println("Time Analysis:Normally:End");
        
        
        
        class MyRecursiveAction extends RecursiveAction {
            private final Integer MAXCAP = new Integer(1000);
            private Integer[] data;
            private Integer start;
            private Integer end;
            
            MyRecursiveAction(Integer[] data, Integer start, Integer end) {
                this.data = data;
                this.start = start;
                this.end = end;
            }
            
            @Override
            public void compute() {
                if((end - start) <= MAXCAP) {
                    for(int i = start; i <= end; i++) {
                        data[i] = ThreadLocalRandom.current().nextInt(0, 100);
                    }
                }
                else {
                    int halfway = ((end - start) / 2) + start;
                    MyRecursiveAction left = new MyRecursiveAction(data, start, halfway);
                    MyRecursiveAction right = new MyRecursiveAction(data, halfway, end);
                    left.fork();
                    right.compute();
                    left.join();
                }
            }
        };
        class MyRecursiveTask extends RecursiveTask<Integer> {
            private final Integer MAXCAP = 1000;
            private Integer[] data;
            private Integer start;
            private Integer end;
            
            MyRecursiveTask(Integer[] data, Integer start, Integer end) {
                this.data = data;
                this.start = start;
                this.end = end;
            }

            @Override
            protected Integer compute() {
                int result = -1;
                if((end - start) <= MAXCAP) {
                    for(int i = start; i < end; i++) {
                        if(data[i] > result) {
                            result = data[i];
                        }
                    }
                    return result;
                }
                else {
                    int halfway = (end - start) / 2;
                    MyRecursiveTask left = new MyRecursiveTask(data, start, (start + halfway));
                    MyRecursiveTask right = new MyRecursiveTask(data, (end - halfway), end);
                    left.fork();
                    Integer result1 = right.compute();
                    Integer result2 = (Integer)left.join();
                    if(result1 > result2) {
                        return result1;
                    }
                    else if(result2 > result1) {
                        return result2;
                    }
                    else {
                        return result1;
                    }
                }
            }
            
        };
        ForkJoinPool fjp = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        
        //Use of RecursiveAction for initializing array
        System.out.println("Time Analysis:RecursiveAction:Start");
        MyRecursiveAction task1 = new MyRecursiveAction(data, 0, data.length);
        startTime = System.currentTimeMillis();
        ForkJoinTask ret1 = fjp.submit(task1);
        while(!ret1.isDone()) {
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time Taken in Init RecursiveAction: " + (endTime - startTime));
        System.out.println("Time Analysis:RecursiveAction:End");
        
        //Use of RecursiveTask to find greatest number, it exits multiple time return first occurance
        System.out.println("Time Analysis:RecursiveTask:Start");
        MyRecursiveTask task2 = new MyRecursiveTask(data, 0, data.length);
        startTime = System.currentTimeMillis();

        ForkJoinTask ret2 = fjp.submit(task2);
        while(!ret2.isDone()) {
            try {
                System.out.println("DD:" + ret2.get());
            }
            catch(InterruptedException | ExecutionException ex) {ex.printStackTrace();}
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time tasken " + (endTime - startTime));
        
//        Integer result = (Integer)fjp.invoke(task2);
//        endTime = System.currentTimeMillis();
//        System.out.println("MAX: " + result);
//        System.out.println("Time tasken " + (endTime - startTime));
        System.out.println("Time Analysis:RecursiveTask:End");
        /**/
    }
    
    /**
     *
     * @param args
     */
    public static void main(String...args) {
        ExectutorTesting testing = new ExectutorTesting();
        testing.go();
    }
}

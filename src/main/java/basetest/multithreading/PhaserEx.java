package basetest.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Phaser: It is a reusable synchronization barrier which can acts as
 * CountDownLatch or CyclicBarrier with more other flexible features. It does
 * not define the number of cycle/phase in advance while creating Phaser. To
 * terminate when onAdvance() method returns true and we can override. When
 * onAdvance() return true, all threads/parties are release for execution. Force
 * termination of Phaser is also possible by invoking method forceTermination().
 * 
 * arriveAndAwaitAdvance() method sends the parties/thread into waiting, when
 * all parties reached to this point, all are started execution and advance is
 * performed, means the phase is increased by one that means second phase is
 * started.
 * 
 * Finally, the onAdvace() checks the logic to terminate the Phaser and returns
 * true then Phaser stops blocking parties and execution performed.
 * 
 * The current running phase can be obtained by getPhase() method.
 */
public class PhaserEx {
    
    public static void main(String[] args) throws InterruptedException {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int a = 0, b = 1;
                    for (int i = 0; i < 2000000000; i++) {
                        a = a + b;
                        b = a - b;
                    }
                }
            };
           tasks.add(runnable);
        }
        new PhaserEx().runTasks(tasks);


        Thread.sleep(10000);
        printdata();
    }

    void runTasks(List<Runnable> tasks) throws InterruptedException {
        final Phaser phaser = new Phaser(1) {
            protected boolean onAdvance(int phase, int registeredParties) {
                print("OnAdvane: " + phase + "  registeredParties: " + registeredParties);
                return phase >= 3 || registeredParties == 0; //It return true either registered parties is 0 or phase is 1, that means one cycle has been completed
            }
        };

        for (final Runnable task : tasks) {
            phaser.register();
            new Thread() {
                public void run() {
                    do {
                        print(Thread.currentThread().getName() + ": Wait");
                        phaser.arriveAndAwaitAdvance();
                        print(Thread.currentThread().getName() + ": Resume");
                        task.run();
                    } while (!phaser.isTerminated());
                }
            }.start();
            Thread.sleep(500);
        }
        phaser.arriveAndDeregister();
    }


    private static StringBuilder sb = new StringBuilder();
    private static void print(Object ob) {
        sb.append(ob + "\n");
    }
    private static void printdata() {
        System.out.println(sb);
    }

}    


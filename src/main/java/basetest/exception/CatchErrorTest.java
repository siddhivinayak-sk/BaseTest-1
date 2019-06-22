/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sandeepkumar
 */
public class CatchErrorTest implements Comparable<CatchErrorTest> {
    private long id;
    private String boxedString;
    private String data;
    ConcurrentSkipListSet<CatchErrorTest> obList;
    
    CatchErrorTest() {
        obList = new ConcurrentSkipListSet<CatchErrorTest>();
    }
    
    CatchErrorTest(long id, String boxedString, String data) {
        this.id = id;
        this.boxedString = boxedString;
        this.data = data;
    }
    
    /**
     *
     * @param count
     */
    public void breakTheBoon(long count) {
        try {
            while(count > 0) {
                obList.add(new CatchErrorTest(count, count + "", count + ""));
                count--;
            }
        }
        catch(Throwable tl) {
            System.gc();
            System.out.println("Error: " + tl);
        }
    }

    @Override
    public int compareTo(CatchErrorTest o) {
        return (int) (this.id - o.id);
    }

    /**
     *
     * @param args
     */
    public static void main(String...args) {
        CatchErrorTest test = new CatchErrorTest();
        Thread t1 = new Thread() {
            public void run() {
                test.breakTheBoon(100_000_000_000_00l);
            }
        };
        t1.start();
    }

}

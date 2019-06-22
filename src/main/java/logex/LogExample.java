package logex;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sandeepkumar
 */
public class LogExample {
    Logger logger = LogManager.getLogger(LogExample.class);

    /**
     *
     */
    public static int time = 500;
    
    /**
     *
     */
    public void go() {
        class MyThread extends Thread {
            private boolean run;

            public MyThread() {
                run = true;
                this.start();
            }
            
            public void run() {
                while(run) {
                    generateLog();
                }
            }
            
            public void setRun(boolean flag) {
                run = flag;
            }
        };
        
        MyThread t1 = new MyThread();
    }
    
    /**
     *
     */
    public void generateLog() {
        try {
            Thread.sleep(time);
            int random = (int)(Math.random() * 12);
            addLog(random + "");
        }
        catch(Exception e) {
        }
    }
    
    /**
     *
     * @param id
     */
    public void addLog(String id) {
        if(id.equals("1")) {
            logger.trace("Trace Message!");
        }
        else if(id.equals("2")) {
            logger.debug("Debug Message!");
        }
        else if(id.equals("3")) {
            logger.info("Info Message!");
        }
        else if(id.equals("4")) {
            logger.warn("Warn Message!");
        }
        else if(id.equals("5")) {
            logger.error("Error Message!");
        }
        else if(id.equals("6")) {
            logger.fatal("Fatal Message!");        
        }
        else if(id.equals("7")) {
            logger.trace("Trace Message!", new Exception("E" + id));
        }
        else if(id.equals("8")) {
            logger.debug("Debug Message!", new NumberFormatException("E" + id));
        }
        else if(id.equals("9")) {
            logger.info("Info Message!", new FileNotFoundException("E" + id));
        }
        else if(id.equals("10")) {
            logger.warn("Warn Message!", new ClassCastException("E" + id));
        }
        else if(id.equals("11")) {
            logger.error("Error Message!", new RuntimeException("E" + id));
        }
        else if(id.equals("12")) {
            logger.fatal("Fatal Message!", new Throwable("E" + id));        
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String...args) {
        LogExample le = new LogExample();
        if(args.length > 0) {
            try {
                time = Integer.parseInt(args[0]);
            }
            catch(Exception e) {
            }
        }
        le.go();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author sandeep.kumar
 */
public class RuntimeAndProcessEx {
    public static void main(String...args) {
        Runtime r = Runtime.getRuntime();
        System.out.println("Processors Count: " + r.availableProcessors());
        System.out.println("Free Memory: " + r.freeMemory());
        System.out.println("Max Memory: " + r.maxMemory());
        System.out.println("Total Memory: " + r.totalMemory());
        //r.halt(0); //Halts the application from running next line of code
        //r.exit(0); //Exits the JVM
        r.addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutdown Hook Executed");
            }
        });
        //r.loadLibrary(""); //Loads Dynamic Link Library from give path
        //r.gc(); //Add request to invoke the Garbage Collector
        
        try {
            Process p1 = r.exec("cmd");
            
            
//            Process p2 = new ProcessBuilder()
//                    .directory(new File("c:/"))
//                    .command("cmd", "/c", "start", "dir")
//                    .redirectError(ProcessBuilder.Redirect.PIPE)
//                    .redirectOutput(ProcessBuilder.Redirect.PIPE)
//                    .redirectInput(ProcessBuilder.Redirect.PIPE)
//                    .start();
//            System.setIn(p2.getInputStream());
//            System.setOut(new PrintStream(p2.getOutputStream()));
//            p2.waitFor();


            Process p = Runtime.getRuntime().exec("cmd /c start dir");
            BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                writeer.write("dir");
                writeer.flush();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            
            new Thread() {
                public void run() {
                    String ss = null;
                    System.out.println("Here is the standard output of the command:\n");
                    try {
                        while ((ss = stdInput.readLine()) != null) {
                            System.out.println(ss);
                        }
                    }
                    catch(IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }.start();
            
            new Thread() {
                public void run() {
                    String ss = null;
                    System.out.println("Here is the standard error of the command (if any):\n");
                    try {
                        while ((ss = stdError.readLine()) != null) {
                            System.out.println(ss);
                        }
                    }
                    catch(IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while((line = br.readLine()) != null) {
                System.out.println("Invoked: " + line);
                writeer.write(line);
                writeer.flush();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
    }
}

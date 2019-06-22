/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author sandeep.kumar
 */
public class ExceptionEx {
    public static void main(String...args) {
        System.out.println(ET1.check1());
        
    }
}

class ET1 {
    /**
     * If any code block has finally block, then it must run and if it contains
     * return, this will be returned in any case
     */
    static int check1() {
        try {
            //return 1;
            throw new Exception("Error");
        }
        catch(Exception ex) {
            throw ex;
            //return 2;
        }
        finally {
            return -1;
        }
    }
    
    /**
     * try with/without catch/finally, multi level catch, multi catch
     */
    static void check2() throws IOException {
        //try with catch
        try {
            if(1 == 1) {
                throw new RuntimeException("Runtime");
            }
        }
        catch(Exception ex) { ex.printStackTrace(); }
        
        //try with catch and finally
        try {
            if(1 ==  1) {
                throw new RuntimeException("Runtime");
            }
        }
        catch(RuntimeException ex) {ex.printStackTrace();}
        finally {
            System.out.println("Finally");
        }

        //try with finally
        try {
            if(1 == 1) {
                throw new RuntimeException("Runtime Exception");
            }
        }
        finally {
            System.out.println("Finally");
        }
        
        //try without catch or finally
        try (FileOutputStream fos = new FileOutputStream("xyz");) {
            
        }
        
        //try with single catch
        try {
            if(1 == 1) {
                throw new RuntimeException("Runtime Exception");
            }
        }
        catch(RuntimeException re) { re.printStackTrace(); }
        
        //try with multi-level catch, children exception must be caught before parent exception
        try {
            if(1 == 1) {
                throw new RuntimeException("Runtime Exception");
            }
        }
        catch(RuntimeException re) { re.printStackTrace(); }
        catch(Exception re) { re.printStackTrace(); }

        //try with multi catch, exception must not be in same hierarchy tree
        try {
            if(1 == 1) {
                throw new NumberFormatException("NFE");
            }
            else {
                throw new IOException("IOE");
            }
        }
        catch(NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Propagation of many exception can be done as collectively like 'throws Exception'; or we can define exception as 'throws IOException, ServletException'
     */
    static void check3() throws Exception {
    //static void check3() throws IOException, ServletException {    
        if(1 == 1) {
            try {
                if(1 == 1) {
                    throw new IOException();
                }
                else if(1 == 1) {
                    throw new ServletException();
                }
                else {
                    throw new FileNotFoundException("");
                }
            }
            catch(FileNotFoundException fnfe) {
                throw fnfe;
            }
            catch(IOException ioe) {
                throw ioe;
            }
            catch(ServletException se) {
                throw se;
            }
        }
        else {
            try {
                if(1 == 1) {
                    throw new IOException();
                }
                else if(1 == 1) {
                    throw new ServletException();
                }
                else {
                    throw new FileNotFoundException("");
                }
            }
            catch(IOException | ServletException fnfe) {
                throw fnfe;
            }
        }
    }
    
}


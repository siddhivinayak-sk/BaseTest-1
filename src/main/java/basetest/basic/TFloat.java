/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

/**
 *
 * @author sandeepkumar
 */
public class TFloat {
    
    /**
     *
     * @param args
     */
    public static void main(String...args) {
        Integer i1 = 1000;
        Long l1 = 1000l;
        
        System.out.println(l1.equals(new Long(1000)));
        
        
        float a = 4.72f;
        float b = 2;
        System.out.println(a - b);
        
        float c = a * 1000;
        float d = b * 1000;
        float e = (c - d) / 1000;
        System.out.println(e);
    }
    
}

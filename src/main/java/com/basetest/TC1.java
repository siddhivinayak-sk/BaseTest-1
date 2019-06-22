/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basetest;

import java.io.File;

/**
 *
 * @author sandeep.kumar
 */
public class TC1 {
    
    static { System.out.println("Static Block Excecuted"); }
    
    public static void main(String...args) {
        System.out.println("Test");
        
        String tmpFilePath = "/NBP";
        
        if(null != tmpFilePath) {
            String cPath = TC1.class.getResource("").getFile();
            if(cPath.contains(tmpFilePath)) {
                tmpFilePath = cPath.substring(0, cPath.indexOf(tmpFilePath) + tmpFilePath.length());
            }
        }
        
        
        System.out.println(tmpFilePath);
        
    }
}

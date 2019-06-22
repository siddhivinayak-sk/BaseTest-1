/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.basetest.TC1;
import org.testng.annotations.Test;

/**
 *
 * @author sandeep.kumar
 */
public class Test1 {
 
    @Test
    public void t1() {
        TC1 tc1 = new TC1();
        tc1.main(null);
        System.out.println("Test 1 Performed");
    }
}

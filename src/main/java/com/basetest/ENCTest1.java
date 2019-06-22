/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basetest;

import java.net.URLEncoder;

/**
 *
 * @author sandeep.kumar
 */
public class ENCTest1 {
    public static void main(String...args) throws Exception {
        String input = "sa@321-SK990099SK-01";
        //String input = "+x6z1soaqOMWaulHAXx2k/nsLeI5Zf/j";
        System.out.println("Encrypted: " + EncUtils.encrypt(input));
        System.out.println("Encoded Encrypted: " + URLEncoder.encode(EncUtils.encrypt(input)));
        System.out.println("Decrypted: " + EncUtils.decrypt(input));
    }
    
}

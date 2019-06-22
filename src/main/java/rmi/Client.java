/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author sandeep.kumar
 */
public class Client {
    public static void main(String...args) throws Exception {
        IRemote ob = (IRemote)Naming.lookup("rmi://localhost:1099/o1");
        
        System.out.println(ob.getMessage());
    }
}

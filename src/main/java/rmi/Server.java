/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author sandeep.kumar
 */
public class Server {
    public static void main(String...args) throws Exception {
        Registry r = LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/o1", new IRemoteObject());
    }
}

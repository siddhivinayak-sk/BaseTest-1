/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author sandeep.kumar
 */
public class IRemoteObject extends UnicastRemoteObject implements IRemote {

    public IRemoteObject() throws RemoteException {
        super();
    }
    
    @Override
    public String getMessage() throws RemoteException {
        return "Hello";
    }
    
}

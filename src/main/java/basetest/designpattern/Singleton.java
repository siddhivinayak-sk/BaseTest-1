/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.designpattern;

import java.io.Serializable;

/**
 *
 * @author sandeepkumar
 */
//Singleton with lazy loading and thread-safe
public final class Singleton implements Serializable {
    private static volatile Singleton instance = null;
    
    private Singleton() {}
    
    //Lazy loading and synchronized with double lock
    public static Singleton getSingleton() {
        if(null == instance) {
            synchronized(Singleton.class) {
                if(null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    
    //Serialization protected
    protected Object readResolve() {
    	return getSingleton();
    }
    
    private static Class getClass(String classname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if(classLoader == null)
			classLoader = Singleton.class.getClassLoader();
		return (classLoader.loadClass(classname));
    }
}

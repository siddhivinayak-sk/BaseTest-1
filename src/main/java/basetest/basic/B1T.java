/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.net.URLClassLoader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.PriorityQueue;

/**
 *
 * @author sandeepkumar
 */
public class B1T {
    
    /**
     *
     * @param args
     */
    public static void main(String...args) {
       /* 
       Long l1 = 1l;
       System.out.println(l1.equals(new Long(1)));
       
       
       class A {
           int x;

            public A(int x) {
                this.x = x;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            @Override
            public String toString() {
                return "A{" + "x=" + x + '}';
            }
       }
       
       //HashSet
       TreeSet ts1 = new TreeSet(new Comparator<A>() {
           @Override
           public int compare(A o1, A o2) {
               return o1.x - o2.x;
           }
       });
       ts1.add(new A(5));
       ts1.add(new A(1));
       ts1.add(new A(6));
       ts1.add(new A(7));
       ts1.add(new A(8));
       ts1.add(new A(0));
       ts1.add(new A(1));
       ts1.add(new A(2));
       ts1.add(new A(3));
       System.out.println("--------------------------------");
       ts1.forEach((ele) -> {System.out.println(ele);});
       System.out.println("--------------------------------");
       
       
       
       Integer[] iAr = new Integer[1_00];
       for(int i = 0; i < iAr.length; i++) {
           iAr[i] = i;
       }
       
       
       
       A1 a1 = new A2();
       a1.print();
       A1.printX();
       */
       /*
       Object key = a1;
       int h = 47;
       int xt1  = h ^ (h >>> 16);
       int xt2 = 48 & xt1;
       System.out.println("HashCode: " + h + "         HashCode(h^(h>>>16)): " + xt1 + "           Index: " + xt2);
       */
       
       Map<Integer, String> t1Map = new HashMap<>();
       t1Map.get(5);
       A1 a1 = new A2();
       A1 a2 = new A1();
       


       Thread t1 = new Thread(new Runnable() {
           @Override
           public void run() {
                ClassLoader cl = ClassLoader.getSystemClassLoader();
                try {
                    Object ob1 = cl.loadClass("basetest.A1").newInstance();
                }
                catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
           }
       });
       t1.start();
       
       
   }
}



class A1 {
    
    static {
        System.out.println("A1 Static Block");
    }
    
    public void print() {
        System.out.println("A1");
    }

    public static void printX() {
        System.out.println("SA1");
    }
}

class A2 extends A1 {
    @Override
    public void print() {
        System.out.println("A2");
    }

    public static void printX() {
        System.out.println("SA2");
    }
    
    @Override
    public int hashCode() {
        return 1;
    }
}

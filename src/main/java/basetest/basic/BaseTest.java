/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sandeepkumar
 */
public class BaseTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 129;
        Float f1 = 1f;
        Double d1 = 2.5;
        System.out.println(2.5d == 2.5f);
   
        int i = 10;
        while(++i <= 10) {
            i++;
        }
        System.out.println(i);
        
        double d2 = 0101.0;
        double d3 = 0101;
        double d4 = 0101d;
        double d5 = 0x101;
        double d7 = 0x101d;
        double d8 = 0b101;
        double d9 = 0101f;
        double d10 = 101f;
        double d11 = 101.01f;
        double d12 = 0x101f;
        double d13 = 0101f;
        
        //double d101 = 0b101d;
        //double d102 = 0x101.00;
        //double d103 = 0101a;
        
        System.out.println("0101.0 = " + d2);
        System.out.println("0101 = " + d3);
        System.out.println("0101d = " + d4);
        System.out.println("0x101 = " + d5);
        System.out.println("0x101d = " + d7);
        System.out.println("0b101 = " + d8);
        System.out.println("0101f = " + d9);
        System.out.println("101f = " + d10);
        System.out.println("101.01f = " + d11);
        System.out.println("0x101f = " + d12);
        System.out.println("0101f = " + d13);
        double f2 = 101.01f;
        double f3 = 101.01d;
        System.out.println("101.01f = " + f2);
        System.out.println("101.01d = " + f3);
        System.out.println("0/0.0 = " + 0/0.0);
        System.out.println("0.0/0 = " + 0.0/0);
        System.out.println("0.0/0.0 = " + 0.0/0.0);
        
        System.out.println(Double.BYTES);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_NORMAL);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.NaN);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.SIZE);
        
        //m1(1, 2, 3);
        byte b1 = 1;
        byte b2 = 2;
        byte b3 = 3;
        //m2(b1, b2, b3);
        
        Boolean b10 = new Boolean("True");
        Boolean b11 = new Boolean("0");
        System.out.println("new Boolean(\"True\") == new Boolean(\"0\") : " + b10.equals(b11));
        
        
        
        Double d20 = new Double(100);
        Double d21 = new Double(100);
        double d22 = new Double(100);
        double d23 = 100;
        System.out.println("new Double(100) == new Double(100) : " + (d20 == d21));
        System.out.println("(double d22 = new Double(100)) == new Double(100) : " + (d21 == d22));
        System.out.println("(double d22 = 100) == new Double(100) : " + (d23 == d22));
        System.out.println("100 == new Double(100) : " + (100 == d22));
        System.out.println("new Integer(100) == new Double(100) : " + (new Integer(100) == d22));
        
        
        System.out.println(129 == new Integer(129));
        System.out.println(new Integer(100) == new Integer(100));
        System.out.println(new Integer(127) == new Integer(127));

        char d25 = 100;
        short d24 = 100;

        Number d26 = 7.7f;
        //short d27 = (Short)d26;
        System.out.println(d26);
       
       //Variable overflow test
        int i101 = Integer.MAX_VALUE;
        int i102 = Integer.MAX_VALUE;
        long i103 = i101 + i102; //The calculation will happen with integer container even if result is being added to long
        System.out.println(i103);
        
        
        
        
        
    } 
    
    static void m1 (float f, double d, float f2) {System.out.println("FDF");}
    static void m1 (double f, float d, float f2) {System.out.println("DFF");}
    static void m2 (int i, short s, int j) { System.out.println("ISI"); }
    static void m2 (short i, int s, short j) { System.out.println("SIS"); }
    
}

class A {
    static void display(short a, int b, long c) {
        System.out.println(a+""+b+""+c);
    }
    
    public static void main(String...args) {
        System.out.println(-1.0/-0.0);
    }
}


//class C {
//    int x = 0;
//    
//    C() {
//    }
//    C(int x) {
//        x = x;
//    }
//    void print() {
//        System.out.println(this.hashCode()  + ": " + x);
//    }
//}

//class B {
//    public static void main(String...args) {
//        C c1 = new C();
//        C c2 = new C(10);
//        C c3 = new C(20);
//        C c4 = new C(30);
//        C c5 = new C(40);
//        c1.print();
//        c2.print();
//        c3.print();
//        c4.print();
//        c5.print();
//    }
//}


class C {
    int x = 0;
    int y = 0;
    
    
    C() {
        y = 99;
    }
    C(int x) {
        this();
        this.x = x;
    }
    C(int x, int y) {
        this(x);
        this.y = y;
    }

    void print() {
        System.out.println(this.hashCode()  + ": x=" + x + " y=" + y);
    }
    void printThis() {
        print(this);
    }
    void printThis1() {
        print(getC());
    }
    void print(C c) {
        System.out.println(this.hashCode() + ": X=" + c.x + " Y=" + c.y);
    }
    C getC() {
        return this;
    }
}


class D {
    int x = 1;
    
    class E {
        int x = 2;
        
        void print(int x) {
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(D.this.x);
        }
    }
}


class B {
    public static void main(String...args) {
//        C c1 = new C();
//        C c2 = new C(10);
//        C c3 = new C(20, 200);
//        c1.print();
//        c2.print();
//        c3.print();
//        c1.printThis1();

        D d1 = new D();
        D.E e1 = d1.new E();
        e1.print(100);
    }
}

class E {
    public static void main(String...args) {
        String s1 = new String("Xyz");
        String s2 = "Xyz";
        System.out.println((s1 == s2));
        s1 = s1.intern();
        System.out.println((s1 == s2));
        
        Integer i1 = -95;
        System.out.println(Integer.toString(i1, 2));
        System.out.println(i1.hashCode());
    }
}




















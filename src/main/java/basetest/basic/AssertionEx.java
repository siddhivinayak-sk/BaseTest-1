/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

/**
 * Assertion has been introduced with Java 1.4 for asserting the code result so
 * that developers can do unit testing along with code writing. Below is the 
 * structure of assertion:
 * assert <expression>[:message]
 * @author sandeep.kumar
 */
public class AssertionEx {
    static void message() {
        System.out.println("Message 1");
    }
    static Object message1() {
        return new Object();
    }
    static String message2() {
        return new String("Message");
    }
    static int message3() {
        return 1;
    }
    public static void main(String...args) {
        assert 2 > 1;
        assert 2 > 1 : "Two is not greater than One";
        //assert(3==1):message(); //The method called for getting message must return somthing
        assert (3==1):message1();
        assert (3==1):message2();
        assert (3==1):message3();
        assert(3==1);
        
    }
}

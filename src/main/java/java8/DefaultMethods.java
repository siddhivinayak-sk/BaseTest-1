/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

/**
 *
 * @author sandeep.kumar
 */
interface A1 {
    void process();
    default void doTask() {
        System.out.println("Do Task: A1");
    };
    
    public static void handler1() {
        System.out.println("Hander 1");
    }

    static void handler2() {
        System.out.println("Hander 2");
    }
}

interface A2 {
    void process();
    default void doTask() {
        System.out.println("Do Task: A3");
    };
}

interface A3 extends A1, A2 {
    void process();
    default void doTask() {
        System.out.println("Do Task: A4");
    }
}

class AI1 implements A1, A2 {
    @Override
    public void process() {
        System.out.println("Process: AI1");
    }
    @Override
    public void doTask() {
        System.out.println("Do Task: AI1");
        A1.super.doTask();
    }
}

class AI2 implements A1, A2 {
    @Override
    public void process() {
        System.out.println("Process: AI2");
    }
    @Override
    public void doTask() {
        System.out.println("Do Task: AI2");
        A2.super.doTask();
    }
}

class AI3 implements A1, A2 {
    @Override
    public void process() {
        System.out.println("Process: AI3");
    }
    @Override
    public void doTask() {
        System.out.println("Do Task: AI3");
    }
}

/*
//If default method is available in both inteface, it must be override in implmenter class
class AI4 implements A1, A2 {
    @Override
    public void process() {
        System.out.println("Process: AI4");
    }
}
*/



public class DefaultMethods {
    public static void main(String...args) {
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author sandeepkumar
 * Abstraction: Abstraction is one of the base pillar of object oriented programming
 * approach. In abstraction, the we hide the certain details or implementation of
 * our code from the outside world. In other words, if we write any API and do not
 * want to disclose our code to other developers, we can use abstraction. One another
 * benefit of abstraction is increasing of cohesion among module and loose the coupling.
 * 
 * Java does not provide multiple inheritance; however, we can avail multiple inheritance
 * by using interfaces which is fully abstract form of classes.
 * 
 * Abstraction in java can be implemented in two ways:
 * 1. By using abstract classes
 * 2. By using fully abstraction mechanism interface
 * 
 */

class MyApplication {
    public static void main(String...args) {
        WriteFile wf =  new WriteFile();
        wf.writeFile1(Paths.get("f:/abc.txt"), "Ashish");
    }
}


class WriteFile {
    public boolean writeFile(Path path, String data) {
        boolean result = false;
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.CREATE_NEW);
            result = true;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        if(1 == 1) {
            throw new RuntimeException("Runtime");
        }
        return result;
    }
    public boolean writeFile1(Path path, String data) {
        boolean result = false;
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.CREATE_NEW);
            result = true;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }
}


/**
 * - abstract is a keyword in Java and can apply on both class and instance methods
 * - abstract and final or static can't be used together
 * - if class has a single method abstract, that class will be abstract
 * - You can't instantiate abstract classes
 * - The first concrete class must have to define all the abstract methods of extended abstract class
 * - abstract methods does not have body, curly braces and terminate with semicolon
 * - a class may have non-abstract and abstract methods
 * - there is no meaning of using abstract keyword with private
 * - an abstract class may or may not have any abstract method
 */
abstract class MyAbstractUtil {
    public abstract int sum(int a, int b); //Method declaration
    public abstract int difference(int a, int b);
    public int multiply(int a, int b) {
        return a * b;
    }
    final public int calculateMarks(int a, int b) {
        //The method body will be hindden for the developer who uses the abstract class
        int retVal = 0;
        retVal = sum(a, b);
        retVal = retVal + 5;
        retVal = multiply(retVal, b);
        return retVal;
    }
}

abstract class MyFirstAbstractUtil extends MyAbstractUtil {
    public int difference(int a, int b) { //Method defination
        return a - b;
    }
}

class MyUtil extends MyFirstAbstractUtil {
    public int sum(int a, int b) {
        return a + b;
    }
}

class AbstractionTest {
    public static void main(String...args) {
        MyUtil util = new MyUtil();
        System.out.println(util.calculateMarks(5, 10));
    }
}


/**
 * Interface: Interface are way to implement hundred percent abstraction in Java.
 * - In interfaces we can define the methods and final variable only.
 * - The method declaration in interfaces are always abstract and public, keywords 'abstract' or public are optional
 * - The variable defined inside interfaces are always final, static and public. Keywords are optional
 * - Can't give definition in methods in interfaces (Note: We can give default definition since Java 8)
 * - We can implement multiple inheritance by using interfaces in Java
 * - We can implement one or more interfaces in a single class
 * - An interface can extends another interface
 */
//Dev 1
interface AI1 {}
interface AI2 {}
interface AI3 extends AI1, AI2 {} //Multiple Inheritance in Java using interfaces
class AII1 implements AI3 {}
class AII2 implements AI1, AI2 {}

interface IAction {
    int x = 100;
    boolean doAction();
}
abstract class CAction {
    public abstract boolean doAction();
}

final class Action1 implements IAction {
    public boolean doAction() {
        boolean retVal = false;
        System.out.println("Action1");
        retVal = true;
        return retVal;
    }
}

final class Action2 implements IAction {
    public boolean doAction() {
        boolean retVal = false;
        System.out.println("Action2");
        retVal = true;
        return retVal;
    }
}

final class ActionFactory {
    public static IAction getAction() {
        String actionType = "action2";
        IAction temp = null;
        if("action1".equalsIgnoreCase(actionType)) {
            temp = new Action1();
        }
        else if("action2".equalsIgnoreCase(actionType)) {
            temp = new Action2();
        }
        else {
            throw new RuntimeException(actionType + " action is not available!");
        }
        return temp;
    }
}

//Dev 2
class PerformAction {
    public static void main(String...args) {
        IAction action = ActionFactory.getAction();
        action.doAction();
    }
}

//Example
interface IAnimal {
    public void eat();
}
class CDog implements IAnimal {
    public void eat() {
        System.out.println("Dog is eating...");
    }
}
class CCat implements IAnimal {
    public void eat() {
        System.out.println("Cat is eating...");
    }
}
class CHyna implements IAnimal {
    public void eat() {
        System.out.println("Hyna is eating...");
    }
}
class ITest1 {
    public static void main(String...args) {
        CDog d1 = new CDog();
        d1.eat();
        
        CCat c1 = new CCat();
        c1.eat();
        
        CHyna h1 = new CHyna();
        h1.eat();
        
        IAnimal a1 = d1;
        IAnimal a2 = c1;
        IAnimal a3 = h1;
        
        a1.eat();
        a2.eat();
        a3.eat();
    }
}





























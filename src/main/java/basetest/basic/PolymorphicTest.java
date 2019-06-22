/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.util.Date;

/**
 *
 * @author sandeepkumar
 */
public class PolymorphicTest {
    public static void main(String...args) {
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("A");
        p1.setDob(new Date());
        p1.printMe();
        p1.printMe("ABC"); //Calling of overloaded method (p1.printMe())
        
        Employee e1 = new Employee();
        e1.setId(2);
        e1.setName("B");
        e1.setDob(new Date());
        e1.setSalary(10000);
        e1.printMe(); //Calling of overriden method
        e1.printMe("Abc"); //Calling of overloaded/overriden method
        
        //Employee e2 = new Person(); Not possible
        
        Person p2 = new Employee(); //Implicit casting
        p2.setId(3);
        p2.setName("C");
        p2.setDob(new Date());
        //p2.setSalary(10000); //Compile Time binding does not resolve this method because it not available in Person class
        p2.printMe(); //It will be compiled because it is available in Person class but this calling will execute method of Employee class so it's called runtime binding
        p2.printMe("Xyz"); //It will be compiled because it is available in Person class but this calling will execute method of Employee class so it's called runtime binding
        
        p2.printSMe(e1); //It executes the body of Person class as Static methods does not support overriden feature 
        p2.printSMe(e1, "STATIC");
        System.out.println(p2.className);
        
        Employee e3 = (Employee)p2; //Exlipcit type casting
        e3.setSalary(10000);
        
        //It may throw ClassCastException
        try {
            Employee e4 = (Employee)p1;
        }
        catch(ClassCastException cce) { cce.printStackTrace(); }
        
        
        
       //Compile-Time Binding: When we comple class, the method binding/checking happens based upon the reference variable type
       //Runtime Binding: At runtime, it excutes the method body of the object which actually exist in reference varilable
       
       
    }
}


class Person {
    private int id;
    private String name;
    private Date dob;

    public static String className = "Person";
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public void printMe() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("__________________________________");
        System.out.println("Person - printMe()");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    //Non-static method overloading
    public void printMe(String from) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("From: " + from + " __________________________________");
        System.out.println("Person - printMe(String from)");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    public static void printSMe(Person p) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("__________________________________");
        System.out.println("Person - printSMe(Person p)");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Date of Birth: " + p.getDob());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    //Static Method Overloading
    public static void printSMe(Person p, String from) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("From: " + from + " __________________________________");
        System.out.println("Person - printSMe(Person p, String from)");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Date of Birth: " + p.getDob());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}

class Employee extends Person {
    private double salary;
    
    public static String className = "Employee";

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public void printMe() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("__________________________________");
        System.out.println("Employee - printMe()");
        System.out.println("Id: " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Date of Birth: " + super.getDob());
        System.out.println("Salary: " + salary);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    //Overloaded method of public void printMe() 
    @Override
    public void printMe(String from) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("From: " + from + " __________________________________");
        System.out.println("Employee - printMe(String from)");
        System.out.println("Id: " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Date of Birth: " + super.getDob());
        System.out.println("Salary: " + salary);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    //@Override - Not possible with static methods
    public static void printSMe(Person p) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("__________________________________");
        System.out.println("Employee - printSMe(Person p)");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Date of Birth: " + p.getDob());
        if(p instanceof Employee) {
            Employee e = (Employee)p;
            System.out.println("Salary: " + e.salary);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    public static void printSMe(Person p, String from) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Start xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("From: " + from + " __________________________________");
        System.out.println("Employee - printSMe(Person p, String from)");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Date of Birth: " + p.getDob());
        if(p instanceof Employee) {
            Employee e = (Employee)p;
            System.out.println("Salary: " + e.salary);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx End   xxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}


    /*
    Beginners Level
        <return type> <method name>([List of arguments]) {
    
        }
    Higher Level
        [access modifier] [other modifiers] <return type> <method name>([List of arguments]) [throws Exceptions] {
    
        }

        Type Casting: It refers the process of coversion of data types from one data type to other
        1. Implicit Type Casting: If we convert any lower type to higher type, called implict type casting and does not require any additional code. Also, called widening in case of boxing
        2. Explicit/Forcebly Type Casting: If we convert any higher type to lower type, called exlicit type casting and needs addinal target type in code. It may loose the data also. Also called norrowing in case of boxing

    */
    

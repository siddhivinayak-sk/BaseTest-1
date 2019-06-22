/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializationtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 *
 * @author sandeep.kumar
 * 
 * Serializable interface
 * Externalizable interface
 * serialVersionUID
 * static
 * transient
 * readObject(ObjectInputStream ois), writeObject(ObjectOutputStream oos) 
 * 
 */
public class STest {

    public static void main(String...args) {
        EmployeeA a = new EmployeeA();
        a.setId(101);
        a.setName("A");
        a.setAddress("AD");
        a.setSalary(10.0f);
        a.setDoj(new Date());

        EmployeeB b = new EmployeeB();
        b.setId(102);
        b.setName("B");
        b.setAddress("BD");
        b.setSalary(20.0f);
        b.setDoj(new Date());
        b.setBox("Box");
        EmployeeB.setBox1("Box1");

        EmployeeC c = new EmployeeC();
        c.setId(103);
        c.setName("C");
        c.setAddress("CD");
        c.setSalary(30.0f);
        c.setDoj(new Date());

        EmployeeD d = new EmployeeD();
        d.setId(104);
        d.setName("D");
        d.setAddress("DD");
        d.setSalary(40.0f);
        d.setDoj(new Date());
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/file1.txt"));
            oos.writeObject(b);
            oos.writeObject(c);
            oos.writeObject(d);
            oos.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        EmployeeB.setBox1("");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/file1.txt"));
            Object ob1 = ois.readObject();
            System.out.println(ob1.toString());

            Object ob2 = ois.readObject();
            System.out.println(ob2.toString());

            Object ob3 = ois.readObject();
            System.out.println(ob3.toString());
            
            ois.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

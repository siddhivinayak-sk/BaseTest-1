/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializationtest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sandeep.kumar
 */
class EmployeeA {
    private Integer id;
    private String name;
    private String address;
    private float salary;
    private Date doj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", doj=" + doj + '}';
    }
    
    
}


class EmployeeB implements Serializable {
    private static long serialVersionUID = 0L;
    private Integer id;
    private String name;
    private String address;
    private float salary;
    private Date doj;
    private transient String box;
    private static String box1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public static String getBox1() {
        return box1;
    }

    public static void setBox1(String box1) {
        EmployeeB.box1 = box1;
    }

    @Override
    public String toString() {
        return "EmployeeB{" + "id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", doj=" + doj + ", box=" + box + ", box1=" + box1 + '}';
    }
    
    
}


class EmployeeC implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private float salary;
    private Date doj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }
    
    
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        this.setId((Integer)s.readObject());
        this.setName((String)s.readObject());
        this.setSalary(s.readFloat());
        this.setDoj((Date)s.readObject());
    }
    
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException, ClassNotFoundException {
        s.writeObject(this.getId());
        s.writeObject(this.getName());
        s.writeFloat(this.getSalary());
        s.writeObject(this.getDoj());
    }

    @Override
    public String toString() {
        return "EmployeeC{" + "id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", doj=" + doj + '}';
    }
    
    
}


class EmployeeD implements Externalizable {
    
    private Integer id;
    private String name;
    private String address;
    private float salary;
    private Date doj;

    public EmployeeD() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getId());
        out.writeObject(this.getName());
        out.writeObject(this.getAddress());
        out.writeFloat(this.getSalary());
        out.writeObject(this.getDoj());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setId((Integer)in.readObject());
        this.setName((String)in.readObject());
        this.setAddress((String)in.readObject());
        this.setSalary(in.readFloat());
        this.setDoj((Date)in.readObject());
    }

    @Override
    public String toString() {
        return "EmployeeD{" + "id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", doj=" + doj + '}';
    }
    
    
}

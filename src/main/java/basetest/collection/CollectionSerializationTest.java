/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sandeepkumar
 */
public class CollectionSerializationTest {
    public static void main(String...args) {
        new CollectionSerializationTest().go();
    }
    
    public void go() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:/test.txt"));
            List<PersonEntity> pList = new ArrayList<>();
            pList.add(new PersonEntity(1, "A", "AAA"));
            pList.add(new PersonEntity(2, "B", "BBB"));
            pList.add(new PersonEntity(3, "C", "CCC"));
            pList.add(new PersonEntity(4, "D", "DDDD"));
            pList.add(new PersonEntity(5, "E", "EEE"));
            pList.add(new PersonEntity(6, "F", "FFF"));
            pList.add(new PersonEntity(7, "G", "GGG"));
            pList.add(new PersonEntity(8, "H", "HHH"));
            pList.add(new PersonEntity(9, "I", "III"));
            pList.add(new PersonEntity(0, "J", "JJJ"));
            oos.writeObject(pList);
            oos.close();
            
            Thread.sleep(3000);
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:/test.txt"));
            List<PersonEntity> ipList = (List<PersonEntity>)ois.readObject();
            ois.close();
            for(PersonEntity pe:ipList) {
                System.out.println(pe);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}



class PersonEntity implements Serializable {
    private int id;
    private String name;
    private String address;
    private Date date;

    private PersonEntity() {
    }

    public PersonEntity(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = new Date();
    }
    
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonEntity other = (PersonEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    
}

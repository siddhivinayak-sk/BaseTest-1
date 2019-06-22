/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

/**
 *
 * @author sandeepkumar
 * 
 * Here, There are three classes, Animal (parent), Cat (child, Cat extends Animal)
 * and Dog (child, Dog extends Animal)
 * 
 */
public class UpcastingDowncating {
    
    public void go() {
        Animal a1 = new Animal(1, "Puma");
        Dog d1 = new Dog("Bark Loudly", 2, "Rocky");
        Cat c1 = new Cat("Mayau", 2, "Blacky");
        
        Animal a2 = d1; //Up-casting, means placing child object into parent reference variabbles
        Animal a3 = c1; //Up-casting
        
        Dog d2 = (Dog)a2; //Down-casting

        a2 = null;
       
        if(a2 instanceof Dog) {
            Dog d3 = (Dog)a2;
            System.out.println(d3.getBark());
        }
        else if(a2 instanceof Cat) {
            Cat c2 =  (Cat)a2;
        }
        else if(a2 instanceof Object) {
            System.out.println("Object");
        }
        else {
            System.out.println("Null");
        }
        
        System.out.println(null instanceof Object);
    }

    public static void main(String...args) {
        new UpcastingDowncating().go();
    }
}




class Animal {
    private int uniqueId;
    private String name;

    public Animal(int uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
    }
    
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Cat extends Animal {
    private String yowl;

    public Cat(String yowl, int uniqueId, String name) {
        super(uniqueId, name);
        this.yowl = yowl;
    }

    public String getYowl() {
        return yowl;
    }

    public void setYowl(String yowl) {
        this.yowl = yowl;
    }
}

class Dog extends Animal {
    private String bark;

    public Dog(String bark, int uniqueId, String name) {
        super(uniqueId, name);
        this.bark = bark;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}



class Animal1 {
void run()
{
System.out.println("run animal");
}
void run1()
{
System.out.println("run1 animal");
}
}

class Dog4 extends Animal1 
{
    @Override
void run()
{
System.out.println("run dog");
}

  static void method(Animal1 a) {
       Dog4 d=(Dog4)a;//downcasting
       d.run();
       d.run1();
       System.out.println("ok downcasting performed");
  }

  public static void main (String [] args) {
    Animal1 a=new Dog4();
    Dog4.method(a);
     }
}
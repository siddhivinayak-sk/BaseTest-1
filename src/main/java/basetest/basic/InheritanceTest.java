package basetest.basic;

import java.io.Serializable;

public class InheritanceTest {
	public static void main(String...args) {
		Skoda s1 = new Skoda();
		s1.setColor("Gray");
		s1.setName("Lxi");
		s1.setWheels(4);
		
		System.out.println(s1.getColor());
		s1.fuel();
		s1.run();
		s1.printVehicleInfo();
		System.out.println(s1.MAX_COST);
	}
}


interface Transportable extends Serializable {
	double MIN_COST = 0.0;
	double MAX_COST = 99999999999999999999.99;
	
	void run();
}

abstract class Vehicle implements Transportable {
	protected int wheels;
	protected String name;
	
	public void run() {
		System.out.println(name + " Vehicle Running with " + wheels + " wheels");
	}
	
	public abstract void fuel();

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Car extends Vehicle {
	public String color;
	
	@Override
	public void fuel() {
		System.out.println("Fueling car...");
	}
	
	@Override
	public void run() {
		System.out.println(name + " Car Running with " + wheels + " wheels");
	}

	public void printVehicleInfo() {
		System.out.println("Wheels: " + wheels);
		System.out.println("Name: " + name);
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

class Skoda extends Car {
	public String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

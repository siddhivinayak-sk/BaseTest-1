package basetest.exception;

import java.io.IOException;

public class ExceptionTest {

	public static void main(String...args) {
		System.out.println(convert1("1"));
		System.out.println(convert1("N"));
		System.out.println(convert2("N"));
	}
	
	
	
	/*
	 * Try-Catch and return test
	 * 
	 * Remember:
	 * - If try must be followed by: catch, finally or both (catch and finally)
	 * - In case try followed by finally (either after catch or direct). Finally will always run
	 * - If return has been written finally, the other returns like in try or catch will not work.
	 *   means, in all case only return in finally will work. In case of exception, catch statements
	 *   will run but return will happen only from finally
	 */
	static int convert1(String number) {
		try {
			int retVal = Integer.valueOf(number);
			return retVal;
		}
		finally {
			return -1;
		}
	}
	static int convert2(String number) {
		try {
			int retVal = Integer.valueOf(number);
			return retVal;
		}
		catch(NumberFormatException ex) {
			System.out.println("Ex");
			throw ex;
		}
		finally {
			return -1;
		}
	}
	
}

/**
 * Remember:
 * - The exception type can be places in throws: 
 *   no-exception, same exception, sub-exception and runtime exception type only 
 * - The declaration in method throws of exception type can throws 
 *   Checked Exception without throwing from the code from the method e.g.
 *   IOException can be declared in method throws without having code which
 *   throws IOException in code. 
 * 
 *
 */
//Custom Checked Exception
class CustomIOException extends IOException {
	CustomIOException() {
		super();
	}
	CustomIOException(String msg) {
		super(msg);
	}
	CustomIOException(Throwable throwable) {
		super(throwable);
	}
	CustomIOException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}

//Base Class which methods throwing exception and will be override in sub-classes
class Mammal {
	private String name;
	private boolean live;
	public Mammal() {
		super();
	}
	public Mammal(String name, boolean live) {
		super();
		this.name = name;
		this.live = live;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	public void walking() throws RuntimeException {
		System.out.println("Mammal - walking");
	}
	
	public void swmming() throws IOException {
		System.out.println("Mammal - swmming");
	}
	
	public void running() {
		System.out.println("Mammal - running");
	}
}

//Case 1: Same exception can be thrown
class AnimalX extends Mammal {
	private Integer legs;
	public AnimalX() {
		super();
	}
	public AnimalX(Integer legs) {
		super();
		this.legs = legs;
	}
	public AnimalX(String name, boolean live, Integer legs) {
		super(name, live);
		this.legs = legs;
	}
	public Integer getLegs() {
		return legs;
	}
	public void setLegs(Integer legs) {
		this.legs = legs;
	}
	public void walking() throws RuntimeException { //Same Exception
		System.out.println("AnimalX - walking");
	}
	
	public void swmming() throws IOException { //Same Exception
		System.out.println("AnimalX - swmming");
	}
}

//Case 2: No Exception is being thrown, allowed
class DogX extends AnimalX {
	private int age;
	public DogX() {
		super();
	}
	public DogX(int age) {
		super();
		this.age = age;
	}
	public DogX(String name, boolean live, Integer legs, int age) {
		super(name, live, legs);
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void walking() { //No Exception
		System.out.println("DogX - walking");
	}
	
	public void swmming() { //No Exception
		System.out.println("DogX - swmming");
	}
}

//Case 3: Adding more exception but Exception must be RuntimeException type
class CatX extends AnimalX {
	private int age;
	public CatX() {
		super();
	}
	public CatX(int age) {
		super();
		this.age = age;
	}
	public CatX(String name, boolean live, Integer legs, int age) {
		super(name, live, legs);
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void walking() throws RuntimeException, NumberFormatException { //Added more Exception but must be runtime exception
		System.out.println("CatX - walking");
	}
	
	public void swmming() throws IOException, NumberFormatException { //Added more Exception but must be runtime exception
		System.out.println("CatX - swmming");
	}
}

//Case 4: Sub-Exception can be thrown
class DuckX extends AnimalX {
	private int age;
	public DuckX() {
		super();
	}
	public DuckX(int age) {
		super();
		this.age = age;
	}
	public DuckX(String name, boolean live, Integer legs, int age) {
		super(name, live, legs);
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void walking() throws NumberFormatException { //Added Sub-Exception
		System.out.println("DuckX - walking");
	}
	
	public void swmming() throws CustomIOException { //Added Sub-Exception
		System.out.println("DuckX - swmming");
	}
}

//Case 4: Super-Exception cannot be thrown; 
class HorseX extends AnimalX {
	private int age;
	public HorseX() {
		super();
	}
	public HorseX(int age) {
		super();
		this.age = age;
	}
	public HorseX(String name, boolean live, Integer legs, int age) {
		super(name, live, legs);
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//public void running() throws Exception { //Added any unchecked exception is not allowed 
	//	System.out.println("HorseX - running");
	//}

	//public void walking() throws Exception { //Adding Super-Exception is not allowed
	//	System.out.println("HorseX - walking");
	//}
	
	//public void swmming() throws Exception { //Adding Super-Exception is not allowed
	//	System.out.println("HorseX - swmming");
	//}
}






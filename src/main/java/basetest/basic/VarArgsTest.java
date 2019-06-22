package basetest.basic;

/**
 * Var Arguments has been introduced with Java SE 5.0 which means
 * we can pass argument into method 0 or more. Internally, it treats
 * as Array of given type.
 * 
 * Rules: 
 * - There will be only one Var Args defined into a single method
 * - Var args must be last argument in method
 * - The caller can pass 0 (no argument) to infinite argument to call the method
 * - The Var args can be treat as arrays, means length can be obtained, an array can be passed or null can be passed e.g. for m1(int...i) a call can be made m1(null)
 * - In case of overloading, the Var-args are resolved at last
 * - Can't declare same method with Var-Args and array e.g. void m1(int[] i) and void m1(int...i)
 * 
 * @author sandeep.kumar
 *
 */
public class VarArgsTest {

	public static void main(String...args) {
		//System.out.println(null);
		
		/*
		m1();
		m1(1);
		m1(1, 2, 3);
		m1(new int[] {500, 1000});
		m1(null);
		*/
		
		m2();
		m2(new Object());
		m2(new Object[] {});
		m2(null);
		m2(new Object(), new Object());
		
	}
	
	static void m1() {
		System.out.println("M1 - No Args");
	}
	
	static void m1(int i) {
		System.out.println("M1 - INT");
	}

	static void m1(Object ob) {
		System.out.println("M1 - Object");
	}
	
	static void m1(int...i) {
		System.out.println("\nM1 - INT Var-Args");
		System.out.println("Length: " + i.length);
		System.out.println("Class Name: " + i.getClass().getName());
		
		for(int j = 0; j < i.length; j++) {
			i[0] = 99;
			System.out.print(i[j] + ",");
		}
	}

	
	
	
	
	static void m2() {
		System.out.println("M2 - No args");
	}

	static void m2(Object ob) {
		System.out.println("M2 - Single Argument");
	}

	//static void m2(Object[] ob) {
	//	System.out.println("M2 - Array Argument");
	//}

	static void m2(Object...ob) {
		System.out.println("M2 - VarArgs Argument");
	}
	
}

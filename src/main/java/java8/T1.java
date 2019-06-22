package java8;

public interface T1 {
	void m1();
	
	default void r1() {
		System.out.println("Executed R1");
	}
}

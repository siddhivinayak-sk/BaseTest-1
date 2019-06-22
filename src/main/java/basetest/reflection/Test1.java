package basetest.reflection;

import java.lang.reflect.Field;

public class Test1 {

	static class TT {
		byte a;
		short b;
		char c;
		int d;
		float e;
		long f;
		double g;
		String h;
		boolean i;
		
		Byte a1;
		Short b1;
		Character c1;
		Integer d1;
		Float e1;
		Long f1;
		Double g1;
		Object h1;
		Boolean i1;
		
		byte[] aa;
		short[] ba;
		char[] ca;
		int[] da;
		float[] ea;
		long[] fa;
		double[] ga;
		String[] ha;
		boolean[] ia;
		
		Byte[] a1a;
		Short[] b1a;
		Character[] c1a;
		Integer[] d1a;
		Float[] e1a;
		Long[] f1a;
		Double[] g1a;
		Object[] h1a;
		Boolean[] i1a;
		
	}
	
	
	
	public static void main(String...args) {
		for(Field f:TT.class.getDeclaredFields()) {
			System.out.println(f.getType().getName() + " -- " + f.getName());
		}
	}
}

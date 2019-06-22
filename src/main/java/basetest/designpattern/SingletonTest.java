package basetest.designpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

import org.apache.poi.util.SystemOutLogger;
import java.lang.Object;

public class SingletonTest {

	public static void main(String...args) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/ob.object"));
		Singleton  s1 = Singleton.getSingleton();
		oos.writeObject(s1);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/ob.object"));
		Singleton s2 = (Singleton)ois.readObject();
		ois.close();
		
		ois = new ObjectInputStream(new FileInputStream("d:/ob.object"));
		Singleton s3 = (Singleton)ois.readObject();
		ois.close();
		
		System.out.println(s2);
		System.out.println(s3);
		
		Runnable r1 = () -> {
			try {
				CCLoader cl1 = new CCLoader(Singleton.class.getClassLoader());
				Class c1 = cl1.loadClass("basetest.designpattern.Singleton");
				Singleton s5 = null;
				for(Method m:c1.getDeclaredMethods()) {
					if(m.getName().equals("getSingleton")) {
						m.setAccessible(true);
						s5 = (Singleton)m.invoke(null, null);
					}
				}
				System.out.println(s5);
			}
			catch(Exception ex) {ex.printStackTrace();}
		};
		new Thread(r1).start();

		Runnable r2 = () -> {
			try {
				ClassLoader cl2 = ClassLoader.getSystemClassLoader();
				Class c2 = cl2.loadClass("basetest.designpattern.Singleton");
				Singleton s6 = null;
				for(Method m:c2.getDeclaredMethods()) {
					if(m.getName().equals("getSingleton")) {
						m.setAccessible(true);
						s6 = (Singleton)m.invoke(null, null);
					}
				}
				System.out.println(s6);
			}
			catch(Exception ex) {ex.printStackTrace();}
		};
		new Thread(r2).start();
		
		Method m1 = Class.forName("basetest.designpattern.Singleton").getMethod("getSingleton", null);
		m1.setAccessible(true);
		System.out.println(m1.invoke(null, null));
		
		Method m2 = Class.forName("basetest.designpattern.Singleton").getMethod("getSingleton", null);
		m2.setAccessible(true);
		System.out.println(m2.invoke(null, null));
		
	}
}

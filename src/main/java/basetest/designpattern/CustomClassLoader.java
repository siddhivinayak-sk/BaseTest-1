package basetest.designpattern;

public class CustomClassLoader extends ClassLoader {
	
	private byte[] getBytes() {
		byte[] data = new byte[1];
		try { 
			java.io.InputStream is = SingletonTest.class.getResourceAsStream("Singleton.class");
			data = new byte[is.available()];
			is.read(data);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}
	
	@Override
	public Class loadClass(String name) throws ClassNotFoundException {
		try {
			return super.defineClass(name, getBytes(), 0, getBytes().length);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return super.loadClass(name);
	}
}

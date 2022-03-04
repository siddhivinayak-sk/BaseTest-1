package basetest.multithreading;

/**
 * 
 */
public class ThreadLocalEx {
    
	public static void main(String...args) {
		
		ThreadLocalEx ex = new ThreadLocalEx();
		new Thread(ex.myRunnable1, "1").start();
		new Thread(ex.myRunnable2, "2").start();
		new Thread(ex.myRunnable3, "3").start();
	}
	
	
	
	Resource r = new Resource();

	Runnable myRunnable1 = () -> {
		setValueAndName(r, 1);
		printValue(r);
	};

	Runnable myRunnable2 = () -> {
		setValueAndName(r, 2);
		printValue(r);
	};
	
	Runnable myRunnable3 = () -> {
		setValueAndName(r, 3);
		printValue(r);
	};

	void setValueAndName(Resource r, int v) {
		r.setCount(v);
	}

	void printValue(Resource r) {
		for(int i = 0; i < 5; i++) {
			System.out.println("Thread Name: " + Thread.currentThread().getName() + " Value: " + r.getCount());
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException ie) {}
		}
	}
	
	
	class Resource {
		ThreadLocal<Integer> counter;
		
		public Resource() {
			counter = new ThreadLocal<>();
		}
		
		public int getCount() {
			return counter.get();
		}
		
		public void setCount(int count) {
			counter.set(count);
		}
	}
	
	
}

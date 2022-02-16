package basetest.lambda;

import java.util.ArrayList;
import java.util.Random;

public class LambdaEx {

	public static void main(String...args) {
		System.out.println("Test 1");
		test1();
		System.out.println("Test 2");
		test2();
	}
	
	

	static void test1() {
		//Lambda Expression tests
		MyRandom<Integer> intRandom1 = () -> 1;  //Generic Lambda expression to get object with literal
		MyRandom<Integer> intRandom2 = () -> new Random().nextInt(); //Generic Lambda expression to get object with code
		MySummary<Integer> intSummary1 = (t) -> { //Generic Lambda expression to get object argument
			int retVal = 0;
			for(Integer tmp:t) {
				retVal += tmp;
			}
			return retVal;
		};
		MySummary<Double> intSummary2 = (Double[] t) -> { //Generic Lambda expression to get object with specified type
			double retVal = 0;
			for(Double tmp:t) {
				retVal += tmp;
			}
			return retVal;
		};
		MySummary<Integer> intSummary3 = t -> { //Generic Lambda expression to get object with argument without brackets ()
			int retVal = 0;
			for(Integer tmp:t) {
				retVal += tmp;
			}
			return retVal;
		};
		System.out.println(intRandom1.random());
		System.out.println(intRandom2.random());
		System.out.println(intSummary1.summary(new Integer[] {1, 2, 3, 4, 5}));
		System.out.println(intSummary2.summary(new Double[] {1.0, 2.0, 3.0, 4.0, 5.0}));
		System.out.println(intSummary3.summary(new Integer[] {1, 2, 3, 4, 5}));
		System.out.println(sum((Integer[] t) -> { //Generic Lambda expression to get object and pass to method as argument
			Integer retVal = 0;
			for(Integer tmp:t) {
				retVal += tmp;
			}
			return retVal;
		}, new Integer[] {1, 2, 3, 4, 5}));
		
		var doCalculation = true; //Local variable used into Lambda expression must be effectively final (means no value set to variable after once created and set)
		try {
			System.out.println(sum2((Integer[] t) -> {
				if(!doCalculation) {
					throw new CustomException("No Action Required");
				}
				if(t.length == 0) {
					throw new CustomException("Invalid Input");
				}
				Integer retVal = 0;
				for(Integer tmp:t) {
					retVal += tmp;
				}
				return retVal/t.length;
			}, new Integer[] {1, 2, 3, 4, 5}));
		}
		catch(CustomException ex) {ex.printStackTrace();}
	}
	
	static void test2() {
		//Static method reference - <classname>::<method name>
		System.out.println(getRandomInt(Utility::randomImplStatic)); //static method reference
		System.out.println(getRandom(Utility::<Integer>randomGImplStatic)); //generic static method reference
		System.out.println(sum(Utility::<Integer>sumStatic, new Integer[] {1, 2, 3, 4, 5})); //generic static method reference with argument
		
		//instance method reference - <instance variable name>::<method name>
		Utility utility = new Utility();
		System.out.println(getRandomInt(utility::randomImpl)); //instance method reference
		System.out.println(getRandom(utility::<Integer>randomGImpl)); //generic instance method reference
		System.out.println(sum(utility::<Integer>sum, new Integer[] {1, 2, 3, 4, 5})); //generic instance method reference with argument
		
		//any instance method reference - <Classname>::<method name>
		int count = 0;
		HighTemp[] temps = {new HighTemp(97), new HighTemp(98), new HighTemp(97), new HighTemp(96), new HighTemp(99)};
		count = InstanceMethodWithObjectDemo.counter(temps, HighTemp::sameTemp, new HighTemp(97));
		System.out.println("Temprature equals to 97 = " + count);
		count = InstanceMethodWithObjectDemo.counter(temps, HighTemp::lessThanTemp, new HighTemp(97));
		System.out.println("Temprature less than to 97 = " + count);
		
		//Constructor reference
		System.out.println(InstanceMethodWithObjectDemo.sum(new Integer[] {}, Utility::new, "MyUtility")); //With Argument
		
		System.out.println(InstanceMethodWithObjectDemo.<Integer, Integer>sum1(new Integer[] {}, Utility::new, Integer.valueOf(5))); // with generic argument
		
		//Factory example
		MyFunc4<MyClass<Double>, Double> myfunc1 = MyClass<Double>::new;
		MyFunc4<MyClass2, String> myfunc2 = MyClass2::new;
		MyFunc4<MyClass<String>, String> myfunc3 = MyClass<String>::new;
		
		System.out.println(ConstructorRef.myClassFactory(myfunc1, 101.1).getVal());
		System.out.println(ConstructorRef.myClassFactory(myfunc2, "Test").getVal());
		System.out.println(ConstructorRef.myClassFactory(myfunc3, "Testx").getVal());

		//Collection example of method reference
		new ArrayList().stream().forEach(System.out::println);

		//Create Array with method reference
		MyFunc5<Utility[]> myfunc5 = Utility[]::new;
		Utility[] utilList = myfunc5.func(5);
	}
	
	//Methods which takes Lambda object or method reference
	static int getRandomInt(MyRandom2 random) {
		return random.random();
	}

	static int getRandomInt(MyRandom2 random, Utility utility) {
		return random.random();
	}
	
	static <T extends Number> T getRandom(MyRandom<T> random) {
		return random.random();
	}
	
	static <T extends Number> T sum(MySummary<T> summary, T[] t) {
		return summary.summary(t);
	}
	
	static <T extends Number> T sum2(MySummary2<T> summary, T[] t) throws CustomException {
		return summary.summary(t);
	}
}

class Utility {
	private String name;
	
	Utility() {
		this.name = "Default";
	}
	
	Utility(String name) {
		this.name = name;
	}

	<T> Utility(T name) {
		this.name = "" + name;
	}
	
	//Non-static utility methods
	public int randomImpl() {
		return randomImplStatic();
	}
	
	public <T extends Number> T randomGImpl() {
		return randomGImplStatic();
	}

	public <T extends Number> T sum(T[] t) {
		return sumStatic(t);
	}

	//Static utility methods
	public static int randomImplStatic() {
		return new Random().nextInt();
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> T randomGImplStatic() {
		return (T) Short.valueOf("0");
	}
	
	public static <T extends Number> T sumStatic(T[] t) {
		Number retVal = 0;
		for(Number tmp:t) {
			retVal = retVal.doubleValue() + tmp.doubleValue();
		}
		return (T)retVal;
	}
}

class CustomException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super();
	}
	
	public CustomException(String message) {
		super(message);
	}
}

@FunctionalInterface //Compiler ensures the annotated interface complies with FunctionalInterface rule
interface MyRandom<T extends Number> {
	T random();
}

interface MyRandom2 {
	int random();
}

interface MySummary<T extends Number> {
	T summary(T[] t);
}

interface MySummary2<T extends Number> {
	T summary(T[] t) throws CustomException;
}

interface MyFunc<T> {
	boolean func(T v1, T v2);
}

interface MyFunc2 {
	Utility func(String name);
}

interface MyFunc3<T> {
	Utility func1(T name);
}

class HighTemp {
	private int hTemp;
	public HighTemp(int hTemp) {
		this.hTemp = hTemp; 
	}
	public boolean sameTemp(HighTemp tmp) {
		System.out.println("HighTemp.sameTemp");
		return hTemp == tmp.hTemp;
	}
	public boolean lessThanTemp(HighTemp tmp) {
		System.out.println("HighTemp.lessThanTemp");
		return hTemp < tmp.hTemp;
	}
	public int getHTemp() {
		return hTemp;
	}
}

class HighTempL1 extends HighTemp {
	public HighTempL1(int hTemp) {
		super(hTemp);
	}
	@Override
	public boolean sameTemp(HighTemp tmp) {
		System.out.println("HighTempL1.sameTemp");
		return getHTemp() == tmp.getHTemp();
	}
	@Override
	public boolean lessThanTemp(HighTemp tmp) {
		System.out.println("HighTempL1.lessThanTemp");
		return getHTemp() < tmp.getHTemp();
	}
}


class InstanceMethodWithObjectDemo {
	static <T> int counter(T[] vals, MyFunc<T> f, T t) {
		int count = 0;
		for(T tmp:vals)
			if(f.func(tmp, t)) count++;
		return count;
	}

	static <T extends Number> T sum(T[] vals, MyFunc2 f, String name) {
		Utility utility = f.func(name);
		return utility.sum(vals);
	}

	static <T extends Number, X> T sum1(T[] vals, MyFunc3 f, X name) {
		Utility utility = f.func1(name);
		return utility.sum(vals);
	}

}

interface MyFunc4<R, T> {
	R func(T t);
}

class MyClass<T> {
	private T val;
	
	MyClass(T val) {
		this.val = val;
	}
	
	T getVal() {
		return val;
	}
}

class MyClass2 {
	private String val;
	
	MyClass2(String val) {
		this.val = val;
	}
	
	String getVal() {
		return val;
	}
}

class ConstructorRef {
	static <R, T> R myClassFactory(MyFunc4<R,T> f, T t) {
		return f.func(t);
	}
}

interface MyFunc5<T> {
	T func(int i);
}

interface MyFunc6<R,T> {
	R func(T t);
}

interface Math1 {
	default int doMath(int a) {
		return a * a;
	}
}

class MathC implements Math1 {
	@Override
	public int doMath(int a) {
		return a * 2;
	}
	
	public void test() {
		//this and Super keywords with method reference
		MyFunc6<Integer, Integer> func1 = this::doMath;
		MyFunc6<Integer, Integer> func2 = Math1.super::doMath;
		
		System.out.println(func1.func(5));
		System.out.println(func2.func(5));
	}
}
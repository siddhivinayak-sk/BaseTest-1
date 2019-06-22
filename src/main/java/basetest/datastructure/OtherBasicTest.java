package basetest.datastructure;

public class OtherBasicTest {

	public static void main(String...args) {
		//Fibonacci series
		/*
		int times = 10;
		int f = 0;
		int s = 1;
		int i = 0;
		System.out.println(f);
		System.out.println(s);
		do {
			int sum = (f + s);
			System.out.println(sum);
			f = s;
			s = sum;
			i++;
		} while (i < times);
		*/
		
		//Plindrome
		int number = 123456;
		int stored = number;
		int build = 0;
		int temp = 0;
		do {
			temp = number % 10;
			build = (build * 10) + temp;
			number = number / 10;
		} while (number > 0);
		System.out.println("isPalindrom: " + (stored == build));
	}
}
